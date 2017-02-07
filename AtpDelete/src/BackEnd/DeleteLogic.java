package BackEnd;
import java.io.File;

public class DeleteLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File folder = new File("C:\\Delete");
		deleteFolder(folder);
	}





	public static void deleteFolder(File folderToDeleteFrom){

		File[] allFilesAndFolders = folderToDeleteFrom.listFiles();

		if (folderToDeleteFrom.exists()) {
			if (folderToDeleteFrom.isDirectory()){
				for (File iterator : allFilesAndFolders) {
						if (iterator.exists()  && iterator.isFile()) {iterator.delete();}
				}

			}

		}

	}
}
