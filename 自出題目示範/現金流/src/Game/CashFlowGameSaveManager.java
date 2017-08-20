package Game;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import IO.FileManager;

public class CashFlowGameSaveManager implements Serializable{
	private final String FILE_NAME = "game_save.txt";
	private FileManager fileManager;
	
	public CashFlowGameSaveManager(){
		fileManager = new FileManager(FILE_NAME);
	}
	
	public boolean hasGameSave(){
		return fileManager.hasFile();
	}
	
	public CashFlowGame loadGame() throws IOException, ClassNotFoundException{
		if (hasGameSave())
			return loadSaveGame();
		else
			return startNewGame();
	}
	
	private CashFlowGame loadSaveGame() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileManager.loadFile());
		ObjectInputStream ois = new ObjectInputStream(fis);
		CashFlowGame game = (CashFlowGame)ois.readObject();
		System.out.println("載入遊戲.. ");
		ois.close();
		return game;
	}
	
	public CashFlowGame startNewGame(){
		System.out.println("開始新遊戲");
		return new CashFlowGame(this);	
	}
	
	public void saveGame(CashFlowGame cashFlowGame) throws IOException, ClassNotFoundException{
		FileOutputStream fos = new FileOutputStream(fileManager.loadFile());
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(cashFlowGame);
		oos.close();
	}
	
	public void clearSave(){
		boolean deleteSuccess = fileManager.loadFile().delete();
	}
	
	
}
