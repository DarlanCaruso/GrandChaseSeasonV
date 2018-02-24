package game.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import game.Skill;
import game.etcclass.ELOUserData;
import game.item.EquipItemInfo;
import game.item.KItem;
import game.item.PetInfo;
import packet.OpcodeGame;
import packet.Packet;
import server.Main;
import util.Database;

public class GameCharacter {
	public byte m_cCharType;
    public String m_strCharName;
    public byte m_cPromotion;
    public byte m_cCurrentPromotion;
    public long m_biInitExp; // DB에서 처음 접속시 저장된 Exp.
    public int m_iInitWin;
    public int m_iInitLose;
    public int m_iWin;
    public int m_iLose;
    public long m_biExp;
    public int m_dwLevel;
    public Vector<EquipItemInfo> m_vecEquipItems;
    public Vector<EquipItemInfo> m_vecEquipLookItems;
    public long m_dwEquipPetUID;
    public int SkillPoint;
    public int MaxSkillPoint;
    public int SkillTreePoint;
    public int MaxSkillTreePoint;
    public HashMap<Byte, Vector<Skill>> m_mapEquipSkillSet; // 전직, 스킬세트
    public Vector<Skill> vecEquipSkill;
    public long m_biInitTotalExp; // 누적경험치 DB초기값.
    public long m_biTotalExp;     // 누적경험치( 전체 경험치 )
    public EquipItemInfo m_kChangeWeaponItem; // 무기체인지 아이템
    public boolean m_bChangeWeaponLock; // 무기교체 잠금여부
    public HashSet<Byte> m_setPromotion; // 전직, 0, 1,2,3
    public ELOUserData m_kELOUserData;
    
    public GameCharacter() {
    	m_vecEquipItems = new Vector<EquipItemInfo>();
    	m_vecEquipLookItems = new Vector<EquipItemInfo>();
    	m_mapEquipSkillSet = new HashMap<Byte, Vector<Skill>>();
    	vecEquipSkill = new Vector<Skill>();
    	m_kChangeWeaponItem = new EquipItemInfo();
    	m_setPromotion = new HashSet<Byte>();
    	m_kELOUserData = new ELOUserData();
    	
    	m_cCharType = 0;
    	m_strCharName = "";
        m_cPromotion = 0;
        m_cCurrentPromotion = 0;
        m_biInitExp = 0;
        m_iInitWin = 0;
        m_iInitLose = 0;
		m_iWin = 0;
		m_iLose = 0;
		m_biExp = 0;
		m_dwLevel = 0;
		m_dwEquipPetUID = 0;
		m_biInitTotalExp = 0;
		m_biTotalExp = 0;
		m_bChangeWeaponLock = false;
		
        m_setPromotion.clear();
        m_vecEquipItems.clear();
    }
    
    // 캐릭터 불러오기
 	public static void LoadMyCharacters(GameUser u) {
 		if( null == u.Characters )
 			u.Characters = new Vector<GameCharacter>();
 		
 		u.Characters.clear();
 		
 		Connection con = Database.getConnection();
 		PreparedStatement ps = null;
 		ResultSet rs = null;
 		try {
 			//ps = con.prepareStatement("SELECT * FROM `character` WHERE `LoginUID` = ? ORDER BY `RegDate` ASC");
 			ps = con.prepareStatement("SELECT * FROM `character` WHERE `LoginUID` = ? ORDER BY `CharType` ASC");
 			ps.setInt(1, u.LoginUID);
 			rs = ps.executeQuery();
 			if( rs.first() == true ) {
 				do {
 					GameCharacter temp_char = new GameCharacter();
 					
 					temp_char.m_cCharType = rs.getByte("CharType");
 					temp_char.m_cPromotion = rs.getByte("Promotion");
 					temp_char.m_biInitExp = rs.getLong("Exp");
 					temp_char.m_biExp = rs.getLong("Exp");
 					temp_char.m_dwLevel = rs.getInt("Level");
 					temp_char.m_iInitWin = rs.getInt("Win");
 					temp_char.m_iWin = rs.getInt("Win");
 					temp_char.m_iInitLose = rs.getInt("Lose");
 					temp_char.m_iLose = rs.getInt("Lose");
 					temp_char.SkillPoint = rs.getInt("SkillPoint");
 					temp_char.MaxSkillPoint = rs.getInt("MaxSkillPoint");
 					temp_char.m_bChangeWeaponLock = rs.getBoolean("WeaponChange");
 					temp_char.m_dwEquipPetUID = rs.getLong("PetUID");
 					
 					long WeaponChangeUID = rs.getLong("WeaponChangeUID");
 					if( u.Items.containsKey( WeaponChangeUID ) == true ) {
 						// 무기체인지 아이템이 나에게 있다면
 						temp_char.m_kChangeWeaponItem = new EquipItemInfo( u.Items.get( WeaponChangeUID ) );
 					}
 					
 					LoadMyEquipment(u, temp_char, con); // 장비
 					LoadMySkillset(u, temp_char, con); // 스킬
 					
 					u.Characters.add( temp_char );
 				}while( rs.next() == true );
 			}
 		}catch(Exception e) {
 			e.printStackTrace();
 		} finally {
 			Database.close(con, ps, rs);
 		}
 	}
 	
 	// 장착중인 장비 불러오기
 	public static void LoadMyEquipment(GameUser u, GameCharacter c, Connection con) {
 		c.m_vecEquipItems.clear();
 		
 		PreparedStatement ps = null;
 		ResultSet rs = null;
		
		try {
 			ps = con.prepareStatement("SELECT I.ItemUID, I.ItemID FROM `equipment` as E JOIN `inventory` as I ON E.ItemUID = I.ItemUID WHERE E.`LoginUID` = ? AND E.`CharType` = ?");
 			ps.setInt(1, u.LoginUID);
 			ps.setInt(2, c.m_cCharType);
 			
 			rs = ps.executeQuery();
 			if( rs.first() == true ) {
 				do {
 					long ItemUID = rs.getLong("ItemUID");
 					
 					if( u.Items.containsKey(ItemUID) ) { // 아이템이 존재하는 경우에만 입혀주자
 						KItem kitem = u.Items.get(ItemUID);
 						
 						if( kitem != null ) { // 혹시 모르니 한 번 더 체크..
 							EquipItemInfo item = new EquipItemInfo(kitem);
 							c.m_vecEquipItems.add(item);
 						}
 					}
 				}while( rs.next() == true );
 			}
 		}catch(Exception e) {
 			e.printStackTrace();
 		} finally {
 			Database.close(null, ps, rs);
 		}
 	}
 	
 	// 스킬세트 불러오기
 	public static void LoadMySkillset(GameUser u, GameCharacter c, Connection con) {
 		// 전직 레벨 만큼...
 		for( int i=0; i<4; i++ ) {
 			Vector<Skill> vecSkill = new Vector<Skill>();
 			vecSkill.clear();
 			
 	 		PreparedStatement ps = null;
 	 		ResultSet rs = null;
 			
 			try {
 	 			ps = con.prepareStatement("SELECT * FROM `skill` WHERE `LoginUID` = ? AND `CharType` = ? AND `CharPromotion` = ?");
 	 			ps.setInt(1, u.LoginUID);
 	 			ps.setInt(2, c.m_cCharType);
 	 			ps.setInt(3, i);
 	 			
 	 			rs = ps.executeQuery();
 	 			if( rs.first() == true ) {
 	 				do {
 	 					int setid = rs.getInt("SkillSetID");
 	 					int slotIndex = rs.getInt("SlotIndex");
 	 					int slotID = rs.getInt("SlotID");
 	 					int skillID = rs.getInt("SkillID");
 	 					byte cp = rs.getByte("CharPromotion");
 	 					
 	 					Skill s = new Skill(setid, slotIndex, slotID, skillID, c.m_cCharType, cp);
 	 					vecSkill.add(s);
 	 					
 	 					c.vecEquipSkill.add(s);
 	 				}while( rs.next() == true );
 	 			}
 	 		}catch(Exception e) {
 	 			e.printStackTrace();
 	 		} finally {
 	 			Database.close(null, ps, rs);
 	 		}
 			
 			c.m_mapEquipSkillSet.put((byte)i, vecSkill);
 		}
 		
 	}
    
    public void write_CharacterInfoPacket(Packet p) {
    	p.write(m_cCharType);
    	p.writeUnicodeStringWithLength(m_strCharName);
    	p.write(m_cPromotion);
    	p.write(m_cCurrentPromotion);
    	p.writeLong(m_biInitExp);
    	p.writeInt(m_iInitWin);
    	p.writeInt(m_iInitLose);
    	p.writeInt(m_iWin);
    	p.writeInt(m_iLose);
    	p.writeLong(m_biExp);
    	p.writeInt(m_dwLevel);

    	p.writeInt(m_vecEquipItems.size());
		for( int i=0; i < m_vecEquipItems.size(); i++ )
			m_vecEquipItems.get(i).write_EquipItemInfoPacket( p );

		p.writeInt(SkillPoint);
		p.writeInt(MaxSkillPoint);
		
		p.writeInt(1); // SkillTreePoint
		p.writeInt(0); // MaxSkillTreePoint
		
		p.write(0); // 오류나면 바이트 말고 인트로..
		
		p.writeLong(100); // m_biInitTotalExp
		p.writeLong(100); // m_biTotalExp
		
		m_kChangeWeaponItem.write_EquipItemInfoPacket(p);
		p.writeBool(m_bChangeWeaponLock);
		
		p.writeInt(m_setPromotion.size());
		for( int i=0; i < m_setPromotion.size(); i++ )
			p.write( m_setPromotion.iterator().next() );
		
		m_kELOUserData.write_ELOUserDataPacket( p );
		
		// 시즌5에서 새로 생긴거
		
		p.writeInt(m_cCharType); // 캐릭터 슬롯 위치인가보다
		p.writeHexString("00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 FF FF 00 00 00 00 00 00 00 07 D0 00 00 07 D0 00 00 00 0A 00 00 00 00 00 00 00 5A 00 00 00 64 00 00 00 00 00 00 00 00 00 71 30 29");
    }
    
    // 현재 캐릭터의 KInDoorCharInfo 패킷 생성
    public void write_KInDoorCharInfo( GameUser u, Packet p ){
		p.write(this.m_cCharType);
		p.writeUnicodeStringWithLength(this.m_strCharName);
		p.write(this.m_cPromotion);
		p.write(this.m_cCurrentPromotion);
		p.writeLong(this.m_biExp);
		p.writeInt(this.m_dwLevel);
		p.writeInt(this.m_iWin);
		p.writeInt(this.m_iLose);
		
		int EquipItemSize = m_vecEquipItems.size();
		p.writeInt(EquipItemSize);
		for( int jj=0; jj<EquipItemSize; jj++ ) {
			m_vecEquipItems.get(jj).write_EquipItemInfoPacket( p );
		}
		
		int EquipLookItemSize = m_vecEquipLookItems.size();
		p.writeInt(EquipLookItemSize);
		for( int jj=0; jj<EquipLookItemSize; jj++ ) {
			m_vecEquipLookItems.get(jj).write_EquipItemInfoPacket( p );
		}

		// 펫
		if( m_dwEquipPetUID == 0 ) {
			// 없는 펫 정보를 보낸다
			new PetInfo().write_PetInfoPacket( p );
		} else {
			// 장착중인 펫 찾기
			PetInfo equipPet = null;
			
			int petnum = u.Pets.size();
			for( int kkk=0; kkk<petnum; kkk++ ) {
				if( u.Pets.get(kkk).m_dwUID == m_dwEquipPetUID ) {
					equipPet = u.Pets.get(kkk);
					break;
				}
			}
			
			// 장착중인 펫이 없다면...
			if( equipPet == null )
				new PetInfo().write_PetInfoPacket( p );
			else
				equipPet.write_PetInfoPacket( p );
		}
		
		/*
		int mapSkillSetSize = m_mapEquipSkillSet.size();
		p.writeInt(mapSkillSetSize);
		for( int jj=0; jj<mapSkillSetSize; jj++ ) {
			byte index = it.next();
			p.write( index ); // map이라 인덱스 보내야함
			
			int vecSkillSlotSize = p.readInt();
			for( int kkk=0; kkk<vecSkillSlotSize; kkk++ ) {
				p.readInt(); // 슬롯 인덱스
				p.readInt(); // 슬롯 ID
				p.readInt(); // 스킬 ID
			}
		}
		*/
		p.writeInt(1); // map size
		p.write(0); // map index
		
		//p.writeHexString("00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 FF FF 00 00 00 01 00");
		
		int equipskillsize = vecEquipSkill.size(); 
		p.writeInt( equipskillsize );
		for( int jj=0; jj<equipskillsize; jj++ ) {
			p.writeInt(jj);
			p.writeInt(vecEquipSkill.get(jj).SlotID);
			p.writeInt(vecEquipSkill.get(jj).SkillID);
		}
		
		p.writeInt(SkillPoint);
		p.writeInt(MaxSkillPoint);
		
		//p.writeHexString("00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 00 FF 00 00 00 00 00 00");
		
		m_kChangeWeaponItem.write_EquipItemInfoPacket( p );
		
		/*
		int vecSPInfoSize = p.readInt();
		for( int jj=0; jj<vecSPInfoSize; jj++ ) {
			p.readByte(); // m_cCharType
			p.readByte(); // m_cPromotion
			
			int vecSkillsSize = p.readInt();
			for( int kkk=0; kkk<vecSkillsSize; kkk++ ) {
				p.readInt(); // int m_vecSkills
			}
		}
		*/
		
		p.writeInt(1);
		p.write(m_cCharType);
		p.write(m_cPromotion);
		
		int equipskillsize2 = vecEquipSkill.size(); 
		p.writeInt( equipskillsize2 );
		for( int jj=0; jj<equipskillsize2; jj++ ) {
			p.writeInt(vecEquipSkill.get(jj).SkillID);
		}
		
		p.writeInt(0);
		
		m_kELOUserData.write_ELOUserDataPacket(p);
    }
    
    public static void EVENT_EQUIP_ITEM_REQ(GameUser u, Packet p) {
    	// 돌려줘야해서 벡터 생성...
    	Vector<EquipItemInfo> vecReleaseItemInfo = new Vector<EquipItemInfo>();
    	vecReleaseItemInfo.clear();
    	
    	Connection con = Database.getConnection();
    	
    	String ID = p.readUnicodeStringWithLength();
    	byte CharType = p.readByte();
    	int CharSize = p.readInt(); // m_mapEquipInfo
    	for( int i=0; i<CharSize; i++ ) {
    		byte CharIndex = p.readByte();
    		
    		GameCharacter c = u.getCharacter(CharIndex);
    		
    		// m_vecEquipItems
    		int EquipSize = p.readInt();
    		for( int jj=0; jj<EquipSize; jj++ ) {
    			EquipItemInfo iteminfo = EquipItemInfo.read_EquipItemInfoPacket(p);
    			
    			// 아이템이 인벤토리에 있다
    			if( u.Items.containsKey(iteminfo.m_dwUID) ) {
    				c.m_vecEquipItems.add(iteminfo);
    				
    				// DB
    				try {
						PreparedStatement ps = con.prepareStatement("INSERT INTO equipment (LoginUID, CharType, ItemUID) VALUES (?, ?, ?)");
						ps.setInt(1, u.LoginUID);
						ps.setInt(2, CharIndex);
						ps.setLong(3, iteminfo.m_dwUID);
						ps.executeUpdate();
						ps.close();
					} catch (Exception e) { e.printStackTrace(); }
    			}
    			
    			iteminfo = null;
    		}
    		
    		// m_vecReleaseItems 장착 해제
    		int ReleaseEquipSize = p.readInt();
    		for( int jj=0; jj<ReleaseEquipSize; jj++ ) {
    			EquipItemInfo iteminfo = EquipItemInfo.read_EquipItemInfoPacket(p);
    			
    			vecReleaseItemInfo.add(iteminfo); // 이따가 브로드 패킷에 담아야되서 저장한다
    			
    			for( int kkk=0; kkk<c.m_vecEquipItems.size(); kkk++ ){
    				if( c.m_vecEquipItems.get(kkk).m_dwUID == iteminfo.m_dwUID ) {
    					c.m_vecEquipItems.remove(kkk);
    					break;
    				}
    			}
    				
				// DB
				try {
					PreparedStatement ps = con.prepareStatement("DELETE FROM `equipment` WHERE LoginUID = ? AND CharType = ? AND ItemUID = ?");
					ps.setInt(1, u.LoginUID);
					ps.setInt(2, CharIndex);
					ps.setLong(3, iteminfo.m_dwUID);
					ps.executeUpdate();
					ps.close();
				} catch (Exception e) { e.printStackTrace(); }
				
				iteminfo = null;
    		}
    		
    		// PetInfo
    		PetInfo pet = PetInfo.read_PetInfoPacket(p);
    		
    		// 펫 검사
    		boolean isMyPet = false;
    		if( pet.m_dwUID != 0 ) // 펫을 장착했다고하면..
	    		for( int jj=0; jj<u.Pets.size(); jj++) {
	    			PetInfo mypet = u.Pets.get(jj);
	    			if( pet.m_dwUID == mypet.m_dwUID ) {
	    				// 펫이 존재한다. 벡터 펫 지우고 새로운 펫 넣어주자.. (템 입히기 귀찮)
	    				u.Pets.remove(jj);
	    				u.Pets.add(pet);
	    				
	    				isMyPet = true;
	    				break;
	    			}
	    		}
    		
    		if( isMyPet == true )
    			c.m_dwEquipPetUID = pet.m_dwUID;
    		else
    			c.m_dwEquipPetUID = 0;
			
			
			c.m_cCurrentPromotion = p.readByte();
			
			c.m_kChangeWeaponItem = EquipItemInfo.read_EquipItemInfoPacket(p);
			
			// 있는 아이템만...
			long WeaponChangeItemUID = c.m_kChangeWeaponItem.m_dwUID;
			if( u.Items.containsKey( WeaponChangeItemUID ) == false ) {
				c.m_kChangeWeaponItem = new EquipItemInfo();
				WeaponChangeItemUID = -1;
			}
			
			// DB
			try {
				PreparedStatement ps;
				
				// 캐릭터 정보 변경
				ps = con.prepareStatement("UPDATE `character` SET `PetUID` = ?, `WeaponChangeUID` = ? WHERE `LoginUID` = ? AND `CharType` = ?");
				ps.setLong(1, pet.m_dwUID);
				ps.setLong(2, WeaponChangeItemUID);
				ps.setInt(3, u.LoginUID);
				ps.setInt(4, CharIndex);
				ps.executeUpdate();
				ps.close();
				
				// 펫 아이템 무식하게 코딩함 ㅠㅠ 1개 아님 2개만 낄 수 있을테니까..
				if( isMyPet == true ) {
					// 장착 템 다 지우고
					ps = con.prepareStatement("UPDATE `pet` SET `Slot1` = 0, `Slot2` = 0 WHERE `LoginUID` = ? AND `PetUID` = ?");
					ps.setInt(1, u.LoginUID);
					ps.setLong(2, pet.m_dwUID);
					ps.executeUpdate();
					ps.close();
					
					int itemsize = pet.m_vecEquipItem.size();
					for( int jj=1; jj<=itemsize; jj++ ) {
						ps = con.prepareStatement("UPDATE `pet` SET `Slot" + jj + "` = ? WHERE `LoginUID` = ? AND `PetUID` = ?");
						ps.setLong(1, pet.m_vecEquipItem.get(jj - 1).m_dwUID);
						ps.setInt(2, u.LoginUID);
						ps.setLong(3, pet.m_dwUID);
						ps.executeUpdate();
						ps.close();
					}
				}
			} catch (Exception e) { e.printStackTrace(); }
    	}
  
    	try {
			con.close();
		} catch (Exception e) { e.printStackTrace(); }
    	
    	Packet pBroad = new Packet(OpcodeGame.EVENT_EQUIP_ITEM_BROAD);
    	pBroad.writeUnicodeStringWithLength(u.ID);
    	pBroad.write(u.CurrentChar);
    	pBroad.writeInt(CharSize);
    	for( int i=0; i<CharSize; i++ ) {
    		GameCharacter sc = u.Characters.get(i);
    		pBroad.write( sc.m_cCharType );
    		
    		// m_vecEquipItems
    		pBroad.writeInt(sc.m_vecEquipItems.size());
    		for( int jj=0; jj<sc.m_vecEquipItems.size(); jj++)
    			sc.m_vecEquipItems.get(jj).write_EquipItemInfoPacket(pBroad);
    		
    		// 릴리즈아이템
    		pBroad.writeInt(vecReleaseItemInfo.size());
    		for( int jj=0; jj<vecReleaseItemInfo.size(); jj++)
    			vecReleaseItemInfo.get(jj).write_EquipItemInfoPacket(pBroad);
    		
    		if( sc.m_dwEquipPetUID == 0 ) {
    			// 펫 uid가 없다면
    			PetInfo pet = new PetInfo();
    			pet.write_PetInfoPacket( pBroad );
    		} else {
    			// 펫 uid가 있다면
    			PetInfo pet = null;
    			for( int kkk=0; kkk < u.Pets.size(); kkk++ ) {
    				if( u.Pets.get(kkk).m_dwUID == sc.m_dwEquipPetUID ) {
    					pet = u.Pets.get(kkk);
    					break;
    				}
    			}
    			
    			// 그런데 내 펫 목록에 없는 펫이면 새로 생성..
    			if( pet == null )
    				pet = new PetInfo();

    			pet.write_PetInfoPacket(pBroad);
    		}
    		
    		// job
    		pBroad.write(sc.m_cCurrentPromotion);
    		
    		// 웨폰체인지
    		sc.m_kChangeWeaponItem.write_EquipItemInfoPacket(pBroad);
    	}
    	
    	pBroad.writeInt(u.LoginUID);
    	pBroad.writeShort(u.CurrentRoomNo);
    	
    	u.parent.sendPacket(pBroad, true);
    	
    	// 방에 있다면 방안의 사람들한테도 뿌려준다
    	if( u.CurrentRoom == null )
    		return;
    	
    	for( int i=0; i<6; i++ ) {
    		if( u.CurrentRoom.slots[i].isActive == true )
    			u.CurrentRoom.slots[i].client.sendPacket(pBroad, true);
    	}
    }

	public static void EVENT_UNLOCK_CHANGE_WEAPON_REQ(GameUser u, Packet p) {
		byte CharType = p.readByte();

		Packet pr = new Packet(OpcodeGame.EVENT_UNLOCK_CHANGE_WEAPON_ACK);
		pr.writeInt(0);
		pr.write(CharType);
		pr.writeInt(0);
		u.parent.sendPacket(pr, false);
		
		Main.printmsg("EVENT_UNLOCK_CHANGE_WEAPON_REQ() - 무기체인지 언락은 아직 덜 구현됨");
	}
    
	public static void Send_EVENT_USER_CHANGE_WEAPON_NOT(GameUser u) {
		Packet pr = new Packet(OpcodeGame.EVENT_USER_CHANGE_WEAPON_NOT);
		
		pr.writeInt( u.Characters.size() );
		
		for( int i=0; i<u.Characters.size(); i++ ) {
			GameCharacter c = u.Characters.get(i);
			
			pr.write(c.m_cCharType);
			pr.writeBool(c.m_bChangeWeaponLock);
			pr.writeLong(c.m_kChangeWeaponItem.m_dwUID);
		}
		
		u.parent.sendPacket(pr, false);
	}
}
