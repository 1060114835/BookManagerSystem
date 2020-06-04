package reader;


import domain.Book;

public interface IBookRequest{

	void borrowRequest();

	void returnRequest(Book book);
	 
}
