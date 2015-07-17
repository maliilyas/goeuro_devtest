package writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.UniqueHashCode;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import beans.City;

public class CsvFileWriter implements IWriter{

	@Override
	public boolean write_file(List<City> file_to_write) {
		if(file_to_write != null && file_to_write.size() > 0){
			ICsvBeanWriter citywriter = null;
			try {
				/**
				 * The header is the mapper to the Bean Class of the City
				 */
				final String[] header = new String[] { "_id", "name", "type", "lat","longitutde"};
				final CellProcessor[] processors = getProcessors();

				citywriter = new CsvBeanWriter(new FileWriter("city.csv"),
						CsvPreference.STANDARD_PREFERENCE);

				citywriter.writeHeader(header);

				for( final City city : file_to_write ) {
					citywriter.write(city, header, processors);
				}


			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				if( citywriter != null ) {
					try {
						citywriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}
		return false;
	}
	/**
	 * A place holder for Super CSV , the library I used, I added the library for
	 * super csv as maven wasn't working for this.
	 * @return
	 */

	private static CellProcessor[] getProcessors() {

		final CellProcessor[] processors = new CellProcessor[] { 
				new UniqueHashCode(), // id 
				new NotNull(), // the name for the city
				new Optional(), // the type of the city
				new NotNull(), // Latitude
				new NotNull(), // Longitude
		};

		return processors;
	}

}
