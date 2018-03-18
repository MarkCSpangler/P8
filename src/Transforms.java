// P8 Assignment
// Author: Cole Spangler
// Date: Mar 17, 2018
// Class: CS164
// Email: colespan@rams.colostate.edu

public class Transforms implements ImageInterface {
	public PictureLibrary pictureLibrary;
	int imgWidth = 0;
	int imgHeight = 0;
	int data[][];
	
	public Transforms() {
		pictureLibrary = new PictureLibrary();
	}
	
	@Override
	public void readImage(String inFile) {
		// TODO Auto-generated method stub
		try {
			pictureLibrary.readPGM(inFile);
			pictureLibrary.getHeight();
			pictureLibrary.getWidth();
			pictureLibrary.getData();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void writeImage(String outFile) {
		// TODO Auto-generated method stub
		try {
			pictureLibrary.setData(data);
			pictureLibrary.writePGM(outFile);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public int[][] imageData() {
		// TODO Auto-generated method stub
		return data;
	}

	@Override
	public void decode() {
		// TODO Auto-generated method stub
		for(int i=0;i < data.length;i++) {
			for(int j=0;j < data[i].length;j++) {
				int upr = data[i][j] / 16;
				int lwr = data[i][j] % 16;
				upr = 15 - upr;
				data[i][j] = (upr * 16) + lwr;
			}
		}
	}

	@Override
	public void swap() {
		// TODO Auto-generated method stub
		for(int i=0;i < data.length;i++) {
			for(int j=0; j < data[i].length;j++) {
				int upr = data[i][j] & 0b11000000;
				int lwr = data[i][j] & 0b00000011;
				int mdl = data[i][j] & 0b00111100;
				data[i][j] = (lwr << 6) | mdl | (upr >> 6);
			}
		}
	}

	@Override
	public void mirror() {
		// TODO Auto-generated method stub
		for (int i = 0; i < data.length / 2; ++i) {
			//Storing current array into thisRow variable
		    int[] thisRow = data[i];
		    //Changing current row to last row minus where we're at in the for-loop
		    data[i] = data[(data.length - 1) - i];
		    //Putting the last row minus where we're at in the for loop to the row we started with
		    data[(data.length - 1) - i] = thisRow;
		}
	}

	@Override
	public void exchange() {
		// TODO Auto-generated method stub
		
	}

}
