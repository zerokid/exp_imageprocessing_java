import java.io.IOException;
import java.net.URL;


public class imageprocessing {
	public static void main(String[]args){
		Imagery img=new Imagery();
		try {
			URL url = imageprocessing.class.getResource("test.txt");
			//System.out.print(url.getPath()
			img.LoadFromFile(url.getPath());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		img.DisplayImage();
	}

}
