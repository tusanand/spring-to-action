package edu.asu.diging.springaction.core.data;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import edu.asu.diging.simpleusers.core.model.IUser;
import edu.asu.diging.springaction.core.model.impl.BookImpl;

public interface BookRepository extends PagingAndSortingRepository<BookImpl, Long> {
	
	List<BookImpl> findByBorrower(IUser user);

}