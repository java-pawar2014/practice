package org.restful.contenthandler.resource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.Encoded;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * The resources defines all built in content handlers that are defined and
 * supported by JAX-RS
 * 
 * @author bpawar
 *
 */
@Path("/builtin")
public class BuiltInContentHandlerResource {

	private static final String basePath = "/";

	/**
	 * You allocate implemented instances of {@link StreamingOutput} interface
	 * and return them from your JAX-RS resource methods. When the JAX-RS
	 * runtime is ready to write the response body of the message, the write()
	 * method is invoked on the StreamingOutput instance.
	 * 
	 * @return streamed data as text
	 */
	@GET
	@Path("/streamingoutput")
	@Produces(value = { MediaType.TEXT_PLAIN })
	public StreamingOutput getStreamingOutput() {
		return new StreamingOutput() {

			@Override
			public void write(OutputStream output) throws IOException, WebApplicationException {
				output.write(new String("Response by streaming output").getBytes());

			}
		};
	}

	/**
	 * For reading request message bodies, you can use a raw InputStream or
	 * Reader for inputting any media type.
	 * 
	 * @param is
	 * @throws IOException
	 */
	@PUT
	@Path("/inputstream")
	public void putStuff(InputStream inputStream) throws IOException {
		byte[] bytes = readFromStream(inputStream);
		String input = new String(bytes);
		System.out.println(input);
	}

	@PUT
	@Path("/reader")
	public void putMore(Reader reader) throws IOException {
		String line = null;
		LineNumberReader lineReader = new LineNumberReader(reader);
		do {
			line = lineReader.readLine();
			if (line != null)
				System.out.println(line);
		} while (line != null);
	}

	private byte[] readFromStream(InputStream inputStream) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		byte[] buffer = new byte[1000];
		int wasRead = 0;

		do {
			wasRead = inputStream.read(buffer);
			if (wasRead > 0) {
				outputStream.write(buffer, 0, wasRead);
			}
		} while (wasRead > -1);

		return outputStream.toByteArray();
	}

	/**
	 * Here, we’re using an injected @PathParam to create a reference to a real
	 * file that exists on our disk. Created a java.io.FileInputStream based on
	 * this path and return it as our response body.<br>
	 * The JAX-RS implementation will read from this input stream into a buffer
	 * and write it back out incrementally to the response output stream.
	 * 
	 * @param path
	 * @return
	 * @throws FileNotFoundException
	 */
	@GET
	@Path("/readfile/{filepath: .*}")
	@Produces(value = { MediaType.TEXT_PLAIN })
	public InputStream getFile(@PathParam("filepath") String path) throws FileNotFoundException {

		FileInputStream inputStream = new FileInputStream(basePath + path);

		return inputStream;
	}

	/**
	 * Instances of java.io.File can also be used for input and output of any
	 * media type.
	 * 
	 * @param path
	 * @return
	 */
	@GET
	@Path("/returnfile/{filepath: .*}")
	@Produces(value = { MediaType.TEXT_PLAIN })
	public File getFileFromSystem(@PathParam("filepath") String path) {

		return new File(basePath + path);
	}

	/**
	 * Most of the data formats on the Internet are text based. JAX-RS can
	 * convert any text-based format to and from either a String or an array of
	 * characters.
	 */

	/**
	 * @return array of bytes converting from string
	 */
	@GET
	@Produces(value = { MediaType.TEXT_PLAIN })
	@Path("/returnbytes")
	public byte[] getBytes() {

		return "hello world".getBytes();
	}

	/**
	 * @param bytes
	 *            takes texual input data as array of bytes
	 */
	@POST
	@Consumes(value = { MediaType.TEXT_PLAIN })
	@Path("/readbytes")
	public void postBytes(byte[] bytes) {
		for (byte byt : bytes)
			System.out.println(byt + " " + (char) byt);
		System.out.println(new String(bytes));
	}

	/**
	 * @return string equivalent to xml representation
	 */
	@GET
	@Consumes(value = { MediaType.APPLICATION_XML })
	@Path("/returnstring")
	public String getString() {
		return "<customer><name>John</name></customer>";
	}

	/**
	 * @param str
	 *            inputs the data as string equivalent
	 */
	@POST
	@Consumes(value = { MediaType.TEXT_PLAIN })
	@Path("/readstring")
	public void postString(String str) {
		System.out.println("String : " + str);
	}

	/**
	 * HTML forms are a common way to post data to web servers. Form data is
	 * encoded as the application/x-www-form-urlencoded media type.
	 * 
	 * @param form
	 *            represents all the form data sent with the request
	 * @return all the form data sent with the request
	 */
	@POST
	@Consumes(value = { MediaType.APPLICATION_FORM_URLENCODED })
	@Produces(value = { MediaType.APPLICATION_FORM_URLENCODED })
	@Path("/multimap")
	public MultivaluedMap<String, String> postDataMap(MultivaluedMap<String, String> form) {
		for (String key : form.keySet()) {
			System.out.println(key + "\t:\t" + form.get(key));
		}
		return form;
	}

	/**
	 * The {@link Source} interface represents XML input or output. It is
	 * usually used to perform XSLT transformations on input documents.<br>
	 * Here we have JAX-RS inject a {@link Source} instance that represents our
	 * request body and we’re transforming it using an XSLT transformation. <br>
	 * Except for JAXB, {@link Source} is the only XML-based construct that the
	 * specification requires implementers to support.
	 * 
	 * @param source
	 * @return
	 * @throws TransformerException
	 */
	@POST
	@Consumes(value = { MediaType.APPLICATION_XML })
	@Produces(value = { MediaType.APPLICATION_XML })
	@Encoded
	@Path("/source")
	public String postSource(Source source) throws TransformerException {

		TransformerFactory tFactory = TransformerFactory.newInstance();

		Transformer transformer = tFactory.newTransformer(
				new StreamSource(new File("/home/bpawar/Documents/practice/restful/i_contenthandler/data.xls")));

		StringWriter writer = new StringWriter();
		transformer.transform(source, new StreamResult(writer));

		return writer.toString();
	}
}
