package clientPkg;

public enum Menu{
	HOME,
	CHATS,
	GROUPS,
	INVITE,
	LOGOUT;
	
	public enum ChatMenu{
		SELECT_CHAT,
		WRITE_CHAT,
		READ_CHAT,
		BLOCK,
		REPORT,
		CHATS,
		HOME
	}
	
	public enum GroupMenu{
		SELECT_GROUP,
		NEW_GROUP,
		PUBLIC_GROUPS,
		MY_GROUPs,
		JOIN_GROUP,
		LEAVE_GROUP,
		WRITE,
		ADD_MOD,		//Only Lead Mod
		REM_MOD,		//Only Lead Mod
		CHANGE_LEAD,	//Only Lead Mod
		DELETE_GROUP,	//Only Lead Mod
		SEND_INVITE,
		REPORT_USER,
		GROUPS,
		HOME
	}
	
	public enum Invitations{
		HOME,
		ACCEPT,
		CANCEL
	}
}


