package game.etcclass;

import game.user.DungeonUserInfo;
import game.user.GameUser;
import packet.Packet;
import util.Convert;

public class KInDoorUserInfo {
	public static void write_KInDoorUserInfo( GameUser u, Packet p ) {
		p.writeUnicodeStringWithLength(u.ID);
		p.writeInt(u.LoginUID);
		p.writeUnicodeStringWithLength(u.Nick);
		
		if( u.CurrentRoom == null )
			p.writeInt(0); // 슬롯번호
		else {
			int temp = u.CurrentRoom.GetSlotIndex(u.parent);
			if( temp == -1 )
				p.writeInt(0);
			else
				p.writeInt(temp);
		}
		
		p.write(u.CurrentChar);
		p.write(u.CurrentPromotion);
		p.write(-1); // 태그매치
		p.write(0);
		p.write(-1);
		p.write(0);
		p.write(-1);
		p.write(0); // 태그매치 끝
		
		// 팀, 세르딘0
		if( u.CurrentRoom == null )
			p.writeInt(0);
		else {
			int temp = u.CurrentRoom.GetSlotIndex(u.parent);
			if( temp >= 3 )
				p.writeInt(1);
			else
				p.writeInt(0);
		}
		
		p.write(1); // 성별
		p.writeInt(100); // 나이
		p.write(u.AuthLevel);
		p.writeBool(false); // isObserver
		p.writeInt(u.GamePoint);
		p.writeBool(u.isPCBang);
		p.write(u.PCBangType);
		
		DungeonUserInfo.write_mapDifficulty(p);
		
		// 방장인가
		if( u.CurrentRoom == null )
			p.writeBool(false);
		else {
			p.writeBool( u.CurrentRoom.GetRoomHost() == u.parent );
		}
		
		p.writeBool(true); // 라이브
		p.writeInt( u.Guild.m_dwUID );
		p.writeUnicodeStringWithLength(u.Guild.m_strFileName );
		p.writeUnicodeStringWithLength(u.Guild.m_strName );
        
		int charcount = u.Characters.size(); 
		p.writeInt(charcount); // 캐릭터..
		for( int i=0; i<charcount; i++) {
			// KInDoorCharInfo 
			u.Characters.get(i).write_KInDoorCharInfo(u, p);
		}
		
		// IP
		p.writeInt(3); // size
		p.writeInt(0); // 1번째
		p.writeInt(0); // 2번째
		p.writeIntLE( Convert.IPToInt(u.parent.s.getInetAddress().getHostAddress()) );
		p.writeInt(1); // size
		p.writeShort( (short) 0x7EFE ); // port
		
		// 상태 (준비등)
		if( u.CurrentRoom == null )
			p.writeInt(0);
		else {
			int temp = u.CurrentRoom.GetSlotIndex(u.parent);
			if( temp == -1 )
				p.writeInt(0);
			else
				p.writeInt( u.CurrentRoom.slots[temp].state );
		}
		
		p.writeInt(0); // 프리미엄
		p.writeHexString("00 00 00 02 00 00 00 00 00 00 E5 6A 00 00 00 01 31 7F 24 36 00 00 00 00 01 00 00 E5 88 00 00 00 01 31 7F 24 37 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 00 01 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 00 00 01 00 00 00 00 00 00 00 02 00 00 00 00 00 00 00 00 01 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00");
	}
}
