package util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.avatar_model;
import member.member_DAO;
import monster.monster;
import monster.monster_dao;

public class attack {
	public static String mon(monster mon_data, avatar_model u_data,String no) throws SQLException {
		member_DAO m_dao= new member_DAO();
		int cnt = Integer.parseInt(no);
		int m_hp=mon_data.getHp();
		int m_at=mon_data.getAttack();
		int m_mp=mon_data.getMp();
		int m_def=mon_data.getDef();
		int m_dp=mon_data.getDp();
		int m_level=mon_data.getLevel();
		int hp=u_data.getHp();
		int mp=u_data.getMp();
		int at=u_data.getAttack();
		int def=u_data.getDef();
		int dp=u_data.getDp();
		int level=u_data.getLevel();
		int ex_point=u_data.getEx_now();
		int ex_limit=u_data.getEx_p();
		String mng="["+u_data.getId()+"]-------["+mon_data.getMon_name()+"]<br>";
		mng+="<table>";
		System.out.println(m_level);
		System.out.println(cnt);
		int i=1;
		List<Integer> item = new ArrayList<>();
		if(cnt>1) {
			for(int k=1; k<=cnt; k++) {
				hp=u_data.getHp();
				m_hp=mon_data.getHp();
				String res="승리";
				int x=1;
				int a = (int) (Math.random()*at)-(at/2);
				int b = (int) (Math.random()*m_at)-(m_at-2);
				while(hp!=0 && m_hp!=0) {
					if(x%2==1) {
						m_hp-=((at+a)-m_def);
						if(m_hp<0) m_hp=0;
					}else {
						hp-=((m_at+b)-def);
						if(hp<0) hp=0;
					}
					x++;
				}
				if(hp==0)
					res="패배";
				else {
					int item_ran=(int)(Math.random()*10+1);
					item.add(item_ran);
					ex_point+=m_level;
				}
				mng+="<tr>";
					mng+="<td>";
						mng+=k+"번째 전투 "+ res+" 하였습니다.";
					mng+="</td>";
				mng+="</tr>";
			}
			i=cnt+1;
		}else {
			while(hp!=0 && m_hp!=0) {
				int a = (int) (Math.random()*at);
				int b = (int) (Math.random()*m_at);
				if(i%2==1) {
					m_hp-=((at+a)-m_def);
					if(m_hp<0) m_hp=0;
				}else {
					hp-=((m_at+b)-def);
					if(hp<0) hp=0;
				}
				mng+="<tr>";
				mng+="<td>";
						mng+=u_data.getId()+" / "+hp+"/"+mp+"/"+dp;
				mng+="</td>";
				mng+="<td>   ";
					if(i%2==1) 
						mng+=(at+a)+"공격";
					else
						mng+=((m_at+b)-def)+"피해";
				mng+="   </td>";
				mng+="<td>   ";
					if(i%2==1) 
						mng += ((at+a)-m_def)+"피해";
					else 
						mng+=(m_at+b)+"공격";
				mng+="   </td>";
				mng+="<td>   ";
					mng += m_hp+"/"+m_mp+"/"+m_dp+" / "+mon_data.getMon_name();
				mng+="   </td>";
				mng+="</tr>";
				i++;
			}
		}
		mng+="</table>";
		mng+="<br> <p> "+(i-1)+"번 전투<p>";
		if(cnt==1) {
			if(hp==0)
				mng+="<p>패배....<p>";
			else {
				int item_ran=(int)(Math.random()*10+1);
				item.add(item_ran);
				ex_point+=m_level;
				mng+="<p> 승리! <p>";
			}
		}
		if(ex_point>=ex_limit) {
			level+=(ex_point/ex_limit);
			ex_point %= ex_limit;
			ex_limit= 100*(int)(Math.pow(2,level-1));
		}
		monster_dao mon=new monster_dao();
		mon.get_equip(mon_data.getItem_list(),item,u_data.getId());
		m_dao.get_ex(level,ex_limit,ex_point,u_data.getId());
		return mng;		
	}
}
