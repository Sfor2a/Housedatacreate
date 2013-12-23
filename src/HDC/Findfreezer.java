package HDC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Findfreezer {
	List < freezer > FFL = new ArrayList <> (); //絞り込み終了後のあたらしい冷蔵庫リスト
	public void setFFL ( freezer freezer ) {
		FFL.add ( freezer );
	}
	public List < freezer > getFFL () {
		return FFL;
	}
	
	public Findfreezer () {
	}
	public int personselector () {
		Random rnd = new Random();
		int people = rnd.nextInt( 8 ) + 1;
		return people;
	}
	
	public int personcountspec ( int P ) { //何人家族かをいれるとそれに必要な範囲のスペックを教えてくれる
		int spec = 0;
		spec = ( 70 * P ) + 170;
		return spec; 
	}
	
	public void findfreezerspec ( int spec, ReadFile RF ) { //スペックで冷蔵庫絞り込み
		List < freezer > FL = RF.getfreezerlist(); //冷蔵庫リストを引っ張ってくる
		int minspec = ( int ) ( spec * 0.94 ); //検索範囲の下限上限をせってい
		int maxspec = ( int ) ( spec * 1.06 ); //この範囲のスペックで冷蔵庫を探す
		for ( int i = 0; i < FL.size(); i++ ) {
			int targetspec = FL.get(i).getSpec();
			if ( targetspec > minspec && targetspec < maxspec ) {
				setFFL ( FL.get(i) ); //絞り込んだ家具をリストに追加
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public freezer findfreezercost ( StringBuilder sstr ) {
		List < freezer > CFL = getFFL();
		freezer CCFL = null;
		Collections.sort(CFL, new FreezerComparator());
		int furiwake = ( int ) ( CFL.size() / 2 );
		 //Randomクラスのインスタンス化
        Random rnd = new Random();
        int ranR = rnd.nextInt( CFL.size() - furiwake ) + furiwake; //リッチ用冷蔵庫選び
        int ranP = rnd.nextInt( CFL.size() - furiwake ); //貧乏用冷蔵庫選び
        int get = rnd.nextInt(2);
        if ( get == 1 ) {
        	CCFL = CFL.get( ranR );
        	sstr.append("金持ち");
        }
        else {
        	CCFL = CFL.get( ranP );
        	sstr.append("貧乏");
        }
        return CCFL;
	}
}

@SuppressWarnings("rawtypes")
class FreezerComparator implements java.util.Comparator {
	public int compare ( Object s, Object t ) {
		return ( ( freezer ) s ).getCost() - ( ( freezer ) t ).getCost();
	}
}

