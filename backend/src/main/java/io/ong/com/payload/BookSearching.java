
package io.ong.com.payload;

import lombok.Getter;
import lombok.Setter;

public class BookSearching
{
	@Getter
    @Setter
    private String key;
	@Getter
    @Setter
    private int page;
	@Getter
    @Setter
    private int size;
    
}