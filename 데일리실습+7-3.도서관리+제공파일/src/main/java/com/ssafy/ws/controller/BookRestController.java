package com.ssafy.ws.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.ws.model.dto.Book;
import com.ssafy.ws.model.service.BookService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/book")
public class BookRestController {

	private static final Logger logger = LoggerFactory.getLogger(BookRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	BookService bookService;

	@ApiOperation(value = "모든 책의 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<Book>> listBook() {
		logger.debug("listBook - 호출");
		return new ResponseEntity<>(bookService.list(), HttpStatus.OK);
	}

	@ApiOperation(value = "isbn에 해당하는 책의 정보를 반환한다.", response = Book.class)
	@GetMapping("/{isbn}")
	public ResponseEntity<Book> searchBook(@PathVariable String isbn) {
		logger.debug("searchBook - 호출");
		return new ResponseEntity<>(bookService.search(isbn), HttpStatus.OK);
	}

	@ApiOperation(value = "새로운 책 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createBook(@RequestBody Book bookDto) {
		logger.debug("createBook - 호출");
		if(bookService.create(bookDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "isbn에 해당하는 책의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{isbn}")
	public ResponseEntity<String> modifyBook(@RequestBody Book bookDto) {
		logger.debug("modifyBook - 호출");
		logger.debug("" + bookDto);
		if(bookService.modify(bookDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "isbn에 해당하는 책의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{isbn}")
	public ResponseEntity<String> deleteBook(@PathVariable("isbn") String isbn) {
		logger.debug("deleteBook - 호출");
		if(bookService.delete(isbn)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
