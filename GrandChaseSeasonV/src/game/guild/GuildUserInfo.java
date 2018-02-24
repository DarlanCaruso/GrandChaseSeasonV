package game.guild;

import game.etcclass.KSimpleDate;
import packet.Packet;

public class GuildUserInfo {
	// 나중에 고치기로 하자
	public static void write_NoGuildUserInfoPacket( Packet p ) {
		p.writeInt(0); // UserUID
		p.writeInt(0); // Login Length
		//p.writeUnicodeString(""); // Login
		p.writeInt(0); // Nick Length
		//p.writeUnicodeString(""); // Nick
		p.writeInt(0); // GuildUID
		p.write(-1); // 길드원 등급
		p.write(0); // 캐릭터 등급
		p.writeInt(0); // 기여도
		p.writeInt(0); // 승리회수
		p.writeInt(0); // 패배회수
		p.writeInt(0); // 자기소개 길이
		//p.writeUnicodeString(""); // 자기소개
		KSimpleDate.write_KSimpleDate(p, 0, 0, 0, 0); // 가입날짜
		p.write(0); // 현재 접속
		p.write(0); // 서버UID
		p.writeInt(0); // 현재위치 길이
		//p.writeUnicodeString(""); // 현재위치
		KSimpleDate.write_KSimpleDate(p, 0, 0, 0, 0); // 마지막접속일
		p.write(0); // 길드채널 등급
	}
}
