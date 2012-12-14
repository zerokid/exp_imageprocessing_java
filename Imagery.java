import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Imagery {
	RGB[][] m_element;
	int m_rowsize;
	int m_colsize;
	int m_testcase;
	String m_imgtype;

	void LoadFromFile(String pathtofile) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(pathtofile));

		// get first line : image type
		String line;
		line = in.readLine();
		m_testcase = Integer.parseInt(line);

		// second line : empty
		in.readLine();

		// third line : type
		m_imgtype=in.readLine();

		// fourth line : column / width
		m_colsize = Integer.parseInt(in.readLine());

		// fifth line : row / height
		m_rowsize = Integer.parseInt(in.readLine());


		String delimiter = " ";

		//populate 2darray object in java
		m_element = new RGB[m_colsize][m_rowsize];
		for(int i=0;i<m_rowsize;i++) {
			for(int j=0;j<m_colsize;j++) {
				m_element[i][j] = new RGB();
			}
		}
		for(int cur_row = 0; cur_row < m_rowsize; cur_row++) {
			line = in.readLine();
			String[] temp = line.split(delimiter);
			int col_count = temp.length, cur_col = 0;
			for(int t=0;t<col_count;t++){
				if(t%3 == 0) {
					// initiate 
					m_element[cur_row][cur_col].red = Integer.parseInt(temp[t]);
				}else if(t%3 == 1) {
					m_element[cur_row][cur_col].green = Integer.parseInt(temp[t]);
				}
				else { // n_count%3 == 2
					m_element[cur_row][cur_col].blue = Integer.parseInt(temp[t]);
					++cur_col;
				}
			}

		}
	}
	void DisplayImage() {

		for (int i = 0; i < m_rowsize; ++i)
		{
			for (int j = 0; j < m_colsize; ++j)
			{
				System.out.println("Row #"+j);
				System.out.println("Red   : "+m_element[i][j].red);
				System.out.println("Green : "+m_element[i][j].green);
				System.out.println( "Blue  : "+m_element[i][j].blue);

			}
		}
	}
}
