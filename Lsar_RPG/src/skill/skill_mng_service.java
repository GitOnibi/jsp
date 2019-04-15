package skill;

public class skill_mng_service {
	private skill_DAO s_dao = new skill_DAO();
	
	public boolean Update_Using(int code,String id,int use) {
	
		return s_dao.update_use(code,id,use);
		
	}
}
