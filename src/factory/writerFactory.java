package factory;

import writer.IWriter;
import writer.CsvWriter;

public class writerFactory {
	
	public static IWriter writer(byte writer_type){
		if (writer_type == constants.csv_writer)
			return new CsvWriter();
		else if (writer_type == constants.txt_writer)
			return null; // null should be replaced with proper parser if need arises.
		else throw new IllegalArgumentException("Could Not Find Appropriate Writer!");
	}


}
