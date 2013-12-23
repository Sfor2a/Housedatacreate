package HDC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Findfreezer {
	List < freezer > FFL = new ArrayList <> (); //�i�荞�ݏI����̂����炵���①�Ƀ��X�g
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
	
	public int personcountspec ( int P ) { //���l�Ƒ����������Ƃ���ɕK�v�Ȕ͈͂̃X�y�b�N�������Ă����
		int spec = 0;
		spec = ( 70 * P ) + 170;
		return spec; 
	}
	
	public void findfreezerspec ( int spec, ReadFile RF ) { //�X�y�b�N�ŗ①�ɍi�荞��
		List < freezer > FL = RF.getfreezerlist(); //�①�Ƀ��X�g�����������Ă���
		int minspec = ( int ) ( spec * 0.94 ); //�����͈͂̉�������������Ă�
		int maxspec = ( int ) ( spec * 1.06 ); //���͈̔͂̃X�y�b�N�ŗ①�ɂ�T��
		for ( int i = 0; i < FL.size(); i++ ) {
			int targetspec = FL.get(i).getSpec();
			if ( targetspec > minspec && targetspec < maxspec ) {
				setFFL ( FL.get(i) ); //�i�荞�񂾉Ƌ�����X�g�ɒǉ�
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public freezer findfreezercost ( StringBuilder sstr ) {
		List < freezer > CFL = getFFL();
		freezer CCFL = null;
		Collections.sort(CFL, new FreezerComparator());
		int furiwake = ( int ) ( CFL.size() / 2 );
		 //Random�N���X�̃C���X�^���X��
        Random rnd = new Random();
        int ranR = rnd.nextInt( CFL.size() - furiwake ) + furiwake; //���b�`�p�①�ɑI��
        int ranP = rnd.nextInt( CFL.size() - furiwake ); //�n�R�p�①�ɑI��
        int get = rnd.nextInt(2);
        if ( get == 1 ) {
        	CCFL = CFL.get( ranR );
        	sstr.append("������");
        }
        else {
        	CCFL = CFL.get( ranP );
        	sstr.append("�n�R");
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

