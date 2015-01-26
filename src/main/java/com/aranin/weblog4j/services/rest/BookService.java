package com.aranin.weblog4j.services.rest;

import com.aranin.weblog4j.vo.BookVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class BookService {

	protected final Logger log = LoggerFactory.getLogger(BookService.class);

	@GET
	@Path("/getbook/{name}")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response getBucket(@PathParam("name") String name) {
		System.out.println("I did come here ");
		log.debug("name : " + name);
		BookVO bookVO = null;
		bookVO = new BookVO();
		bookVO.setAuthor("sandeep");
		bookVO.setBookId(1l);
		bookVO.setBookName("howdy");

		if(bookVO == null){
			return Response.status(Response.Status.BAD_REQUEST).build();
		}else{
			return Response.ok(bookVO).build();
		}
	}

	@POST
	@Path("/addbook")
	@Produces({"application/xml","application/json"})
	@Consumes({"application/xml","application/json","application/x-www-form-urlencoded"})
	public Response addBook(@FormParam("name") String bookName,
	                        @FormParam("author") String author) {
		log.debug("inside addBook");
		BookVO bookVO = new BookVO();
		bookVO.setBookName(bookName);
		bookVO.setAuthor(author);
		return Response.ok(bookVO).build();

	}
}