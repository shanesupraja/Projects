package com.Library.librarymanagement.Service;

import com.Library.librarymanagement.Repository.BooksRepo;
import com.Library.librarymanagement.Repository.MembersRepo;
import com.Library.librarymanagement.Repository.TransactionRepo;
import com.Library.librarymanagement.entity.*;
import lombok.NonNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.*;
import java.util.List;


import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)


class TransactionServiceTest
{
    @Mock
    TransactionRepo transactionRepo;
    @Mock
    BooksRepo booksRepo;
    @Mock
    MembersRepo membersRepo;
    @InjectMocks
    TransactionService transactionService;
    Genres genres = new Genres("UUID.randomUUID()","Fiction");
    Authors authors = new Authors("UUID.randomUUID()","John");
    Publisher publisher = new Publisher("UUID.randomUUID()","hello");
    Members member=new Members("143","abc","kukat",123456789,"@gmail.com");
    BookAuthors bookAuthors = new BookAuthors();
    Books book2  = new Books();

    @BeforeEach
    void setUp()
    { book2.setBookId("UUID.randomUUID()");
        book2.setTitle("hii");
        book2.setAuthor(authors);
        book2.setIsbn("123456765");
        book2.setGenres(genres);
        book2.setPublicationYear(2045);
        book2.setQuantity(129);
        book2.setPublisher(publisher);
        bookAuthors.setAuthors(authors);
        bookAuthors.setBooks(book2);
        book2.setBookAuthors(bookAuthors);
    }

    @AfterEach
    void tearDown() {
    }
    //@Test
   void borrowBook()
   {
   }
    @Test
    void testBorrowBook_InvalidTransactionType() {
        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("invalid");
        transactionCreation.setMemberId("UUID.randomUUID()");
        transactionCreation.setBookId("UUID.randomUUID()");
        String result = transactionService.borrowBook(transactionCreation);
        assertEquals("Invalid transaction type. Must be 'borrow',", result);
    }
    @Test
    void testBorrowBook_AlreadyBorrowed()
    {
        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("borrow");
        transactionCreation.setMemberId("UUID.randomUUID()");
        transactionCreation.setBookId("UUID.randomUUID()");
        Members member = new Members();
        member.setMemberId(transactionCreation.getMemberId());
        Books book = new Books();
        book.setBookId(transactionCreation.getBookId());
        when(transactionRepo.findByMembersAndBook(member, book)).thenReturn(Optional.of(new Transactions()));
        String result = transactionService.borrowBook(transactionCreation);
        assertEquals("you have already borrowed the same book", result);
    }
    @Test
    void testBorrowBook_BookNotFound() {
        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("borrow");
        transactionCreation.setMemberId("UUID.randomUUID()");
        transactionCreation.setBookId("UUID.randomUUID()");
        Members member = new Members();
        member.setMemberId(transactionCreation.getMemberId());
        when(booksRepo.findById(transactionCreation.getBookId())).thenReturn(Optional.empty());
        String result = transactionService.borrowBook(transactionCreation);
        assertEquals("book not found", result);
    }
    @Test
    void testBorrowBook_BookNotAvailable() {
        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("borrow");
        transactionCreation.setMemberId("UUID.randomUUID()");
        transactionCreation.setBookId("UUID.randomUUID()");
        Members member = new Members();
        member.setMemberId(transactionCreation.getMemberId());
        Books book = new Books();
        book.setBookId(transactionCreation.getBookId());
        book.setQuantity(0);
        when(booksRepo.findById(book.getBookId())).thenReturn(Optional.of(book));
        String result = transactionService.borrowBook(transactionCreation);
        assertEquals("book is not available", result);
    }

    @Test
    void testBorrowBook_MemberNotFound()
    {
        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("borrow");
        transactionCreation.setMemberId("UUID.randomUUID()");
        transactionCreation.setBookId("UUID.randomUUID()");
        Books book=new Books();
        book.setBookId(transactionCreation.getBookId());
        book.setQuantity(10);
        when(booksRepo.findById(transactionCreation.getBookId())).thenReturn(Optional.of(book));
        when(membersRepo.findById(transactionCreation.getMemberId())).thenReturn(Optional.empty());
        String result=transactionService.borrowBook(transactionCreation);
        assertEquals("member not found",result);

    }

    @Test
    void testBorrowBook_BorrowSuccessful()
    {
        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("borrow");
        transactionCreation.setMemberId("UUID.randomUUID()");
        transactionCreation.setBookId("UUID.randomUUID()");
        Books book=new Books();
        book.setBookId(transactionCreation.getBookId());
        book.setQuantity(10);
        Members member=new Members();
        member.setMemberId(transactionCreation.getMemberId());
        member.setName("John");
        when(booksRepo.findById(transactionCreation.getBookId())).thenReturn(Optional.of(book));
        when(membersRepo.findById(transactionCreation.getMemberId())).thenReturn(Optional.of(member));
        String result=transactionService.borrowBook(transactionCreation);
        assertEquals("Borrow transaction successfully",result.trim());


    }

    @Test
    void testReturnBook_InvalidTransactionType() {

        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("borrow");
        transactionCreation.setMemberId("UUID.randomUUID()");
        transactionCreation.setBookId("UUID.randomUUID()");
        String result = transactionService.returnBook(transactionCreation);
        assertEquals("Invalid transaction type.", result);

    }

    @Test
    void testReturnBook_NotBorrowedBook() {
        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("return");
        transactionCreation.setMemberId("UUID.randomUUID()");
        transactionCreation.setBookId("UUID.randomUUID()");
        Members member = new Members();
        member.setMemberId(transactionCreation.getMemberId());
        Books book = new Books();
        book.setBookId(transactionCreation.getBookId());
        when(transactionRepo.findByMembersAndBook(member,book)).thenReturn(Optional.empty());
        String result = transactionService.returnBook(transactionCreation);
        assertEquals("You have not borrowed this book.", result);
    }

    @Test
    void testReturnBook_Successful()
    {
        TransactionCreation transactionCreation = new TransactionCreation();
        transactionCreation.setTransactionType("return");
        String memberId = UUID.randomUUID().toString();
        String bookId = UUID.randomUUID().toString();
        transactionCreation.setMemberId(memberId);
        transactionCreation.setBookId(bookId);
        Members member = new Members();
        member.setMemberId(memberId);
        Books book = new Books();
        book.setBookId(bookId);
        Transactions transaction = new Transactions();
        transaction.setTransactionType("borrow");
        transaction.setDueDate(new Date());
        transaction.setMembers(member);
        transaction.setBook(book);
        Optional<Transactions> optionalTransaction = Optional.of(transaction);
        when(transactionRepo.findByMembersAndBook(member, book)).thenReturn(optionalTransaction);
        when(booksRepo.save(book)).thenReturn(book);
        String result = transactionService.returnBook(transactionCreation);
        assertEquals("Book returned successfully.", result);



}
@Test
    void getAllTransactions()
    {
        Transactions transaction = new Transactions();
        transaction.setTransactionId("122");
        transaction.setTransactionType("borrow");
        transaction.setMembers(member);
        transaction.setBook(book2);
        List<Transactions> transactionCreationList = new ArrayList<>();
        transactionCreationList.add(transaction);
        when(transactionRepo.findAll()).thenReturn(transactionCreationList);
        List<TransactionDetails> result  = transactionService.getAllTransactions();
        assertNotNull(result);
         assertEquals(transactionCreationList.size(),result.size());

    }

    @Test
    void getTransactionByMemberId()
    {
        Transactions transactions = new Transactions();
        transactions.setTransactionId("1234");
        transactions.setTransactionType("return");
        Members member=new Members("143","abc","kukat",123456789,"@gmail.com");
        transactions.setMembers(member);
        transactions.setBook(book2);
        transactions.setDueDate(new Date());
        transactions.setReturnDate(new Date());
        List<Transactions> expected = new ArrayList<>();
        expected.add(transactions);
        when(transactionRepo.findByMembersMemberId(member.getMemberId())).thenReturn(expected);
        List<TransactionDetails> result = transactionService.getTransactionByMemberId(member.getMemberId());
       assertEquals(expected.size(),result.size());

    }

    @Test
    void getTransactionByBookId()
    {
        Transactions transactions = new Transactions();
        transactions.setTransactionId("1234");
        transactions.setTransactionType("return");
        Members member=new Members("143","abc","kukat",123456789,"@gmail.com");
        transactions.setMembers(member);
        transactions.setBook(book2);
        transactions.setDueDate(new Date());
        transactions.setReturnDate(new Date());
        List<Transactions> expected = new ArrayList<>();
        expected.add(transactions);
        when(transactionRepo.findByBookBookId(book2.getBookId())).thenReturn(expected);
        List<TransactionDetails> result = transactionService.getTransactionByBookId(book2.getBookId());
        assertEquals(expected.size(),result.size());

    }

    @Test
    void getTransactionByMemberIdAndBookId()
    {
        Transactions transactions = new Transactions();
        transactions.setTransactionId("1234");
        transactions.setTransactionType("return");
        Members member=new Members("143","abc","kukat",123456789,"@gmail.com");
        transactions.setMembers(member);
        transactions.setBook(book2);
        transactions.setDueDate(new Date());
        transactions.setReturnDate(new Date());
        List<Transactions> expected = new ArrayList<>();
        expected.add(transactions);
        when(transactionRepo.findListByMembersMemberIdAndBookBookId(member.getMemberId(),book2.getBookId())).thenReturn(expected);
        List<TransactionDetails> result = transactionService.getTransactionByMemberIdAndBookId(member.getMemberId(),book2.getBookId());
        assertEquals(expected.size(),result.size());


    }
}