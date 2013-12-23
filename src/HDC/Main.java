package HDC;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main {

	public static void main(String[] args) {
		ReadFile RF = new ReadFile();
		RF.createNewFreezerList(".\\freezer\\Newdata.txt");
		Findfreezer FR = new Findfreezer();
		for ( int i=0; i<41; i++ ) {
			int ninzuu = FR.personselector();
			FR.findfreezerspec( FR.personcountspec ( ninzuu ), RF );
			StringBuilder sstr = new StringBuilder();
			freezer kekka = FR.findfreezercost ( sstr );
			File file = new File ( ".\\freezer\\kakikomi.txt" ); //書き込むファイル名
			PrintWriter pw;
			try {
				pw = new PrintWriter ( new BufferedWriter ( new FileWriter ( file, true ) ) );
				pw.println ( "人数："+ ninzuu + " 値段：" + kekka.getCost() + " 容量:" + kekka.getSpec() + sstr );
				pw.close();
				System.out.println ( "追加しました" );
			} catch ( IOException e ) {
				System.err.println ( "File cannot be Writed." );
			} //printlnの用意
		}
		
	}

}
