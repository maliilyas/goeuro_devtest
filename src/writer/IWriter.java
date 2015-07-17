package writer;

import java.util.List;

import beans.City;

public interface IWriter {
	
	public boolean write_file(List<City> file_to_write);

}
