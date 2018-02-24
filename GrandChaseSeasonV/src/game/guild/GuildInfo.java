package game.guild;

import game.etcclass.KSimpleDate;
import packet.Packet;

public class GuildInfo {
	public final int GG_BREAKUP  = 0;   // 길드 해산(삭제)
	public final int GG_NEWBIE   = 1;    // 신생 길드
	public final int GG_OFFICIAL = 2;    // 정규 길드

	public final int JS_AUTO_ACCEPT      = 1;  // 바로 가입
	public final int JS_AFTER_DECISION   = 2;  // 가입후 승인
	public final int JS_STOP_JOIN        = 3;  // 가입중지
	
	public final int MS_NORMAL           = 1;  // 정상상태
	public final int MS_REQUEST_CHANGE   = 2;  // 마크변경신청상태
	public final int MS_ACCEPT_CHANGE    = 3;  // 승인성공
	public final int MS_REJECT_CHANGE    = 4;  // 승인실패
	
	public int m_dwUID;            // 길드ID
    public String m_strName;          // 길드명
    public byte m_ucMarkStatus;     // 길드마크 상태
    public int m_nMarkRevision;    // 길드마크 리비전
    public String m_strFileName;      // 길드 마크 이름
    public String        m_strComment;       // 길드소개
    public byte m_ucGrade;          // 길드등급
    public KSimpleDate m_kFoundingDate;    // 길드만든날짜

    public String m_strMasterNick;    // 길마이름
    public String m_strURL;           // 길드URL
    public int m_dwExp;            // 길드경험치
    public int m_dwPoint;          // 길드포인트
    public int m_nNumMembers;      // 길드원 전체수
    public int m_nTotalRank;       // 종합랭킹
    public int m_nMonthlyRank;     // 월간랭킹
    public int m_nWeeklyRank;      // 주간랭킹
    public byte m_ucJoinSetting;    // 가입설정(바로가입,가입후승인,가입중지)
    public int m_GuildBattlePoint; // 길드전 포인트(Battle point, B-point) 길드전 랭킹 산출의 근거, 길드 채널 구분 기준
    
    public GuildInfo() {
    	m_dwUID = 0;
    	m_strName = "";
    	m_ucMarkStatus = 0;
    	m_nMarkRevision = 0;
    	m_strFileName = "";
    	m_strComment = "";
    	m_ucGrade = 0;
    	m_kFoundingDate = new KSimpleDate();
    	m_strMasterNick = "";
    	m_strURL = "";
    	m_dwExp = 0;
    	m_dwPoint = 0;
    	m_nNumMembers = 0;
    	m_nTotalRank = 0;
    	m_nMonthlyRank = 0;
    	m_nWeeklyRank = 0;
    	m_ucJoinSetting = 0;
    	m_GuildBattlePoint = 0;
    }

    // 나중에 고치기로 하자
 	public static void write_NoGuildInfoPacket( Packet p ) {
 		p.writeInt(0); // 길드id
 		p.writeStringWithLength(""); // 길드명
 		p.write(0); // 길드마크 상태
 		p.writeInt(0); // 길드마크 리비전
 		p.writeStringWithLength(""); // 길드 마크 이름
 		p.writeStringWithLength(""); // 길드소개
 		p.write(0); // 길드등급
 		KSimpleDate.write_KSimpleDate(p, 2017, 1, 1, 1); // 길드만든날짜
 		p.writeStringWithLength(""); // 길마이름
 		p.writeStringWithLength(""); // 길드URL
 		p.writeInt(0); // 길드경험치
 		p.writeInt(0); // 길드포인트
 		p.writeInt(0); // 길드원 전체수
 		p.writeInt(0); // 종합랭킹
 		p.writeInt(0); // 월간랭킹
 		p.writeInt(0); // 주간랭킹
 		p.write(0); // 가입설정
 		p.writeInt(0); // 길드전 포인트
 	}
 	
 	public static void write_NoGuildNoticePacket( Packet p ) {
 		// vector size 개수
 		p.writeInt(0); // size
 		
 		/*
 		p.writeInt(1); // size
 		p.writeInt(0); // ID
 		p.writeUnicodeStringWIthLength("테스트"); // Msg
 		*/
 	}
}
