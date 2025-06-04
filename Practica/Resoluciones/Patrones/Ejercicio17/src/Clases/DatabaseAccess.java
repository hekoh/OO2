package Clases;

import java.util.Collection;
import java.util.List;

public interface DatabaseAccess {
	
    public Collection<String> getSearchResults(String queryString);

    public int insertNewRow(List<String> rowData);
}