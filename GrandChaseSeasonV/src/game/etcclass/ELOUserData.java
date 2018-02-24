package game.etcclass;

import packet.Packet;

public class ELOUserData {
	public final int MT_PLACEMENTTEST = 0; // 배치고사
	public final int MT_NORMAL = 1; // 일반
	
    public int m_nInitELOWin;
    public int m_nELOWin;
    public int m_nInitELOLose;
    public int m_nELOLose;
    public int m_nRatingPoint;
    public int m_nInitRatingPoint;
    public int m_nELOType;
    public int m_nInitMatchTotalCount;
    public int m_nMatchTotalCount;
    public int m_nLastWinLose; // 0 = 패, 1 = 승
    public int m_nConstantK; // 배치고사를 위한 상수 K값 저장.
    public byte m_ucGrade;    // 등급.
    public int m_nPlacementTestPlayCount; // 배치고사 판수.
    
    public ELOUserData() {
    	m_nELOWin = 0;
    	m_nELOLose = 0;
    	m_nRatingPoint = 0;
    	m_nInitRatingPoint = 0;
    	m_nELOType = MT_NORMAL;
    	m_nMatchTotalCount = 0;
    	m_nLastWinLose = 0;
    	m_nConstantK = 0;
    	m_nInitELOWin = 0;
    	m_nInitELOLose = 0;
    	m_nInitMatchTotalCount = 0;
    	m_ucGrade = 0;
    	m_nPlacementTestPlayCount = 0;
    }
    
    public void write_ELOUserDataPacket(Packet p) {
    	p.writeInt( m_nInitELOWin );
    	p.writeInt( m_nELOWin );
    	p.writeInt( m_nInitELOLose );
    	p.writeInt( m_nELOLose );
    	p.writeInt( 1660 ); // m_nRatingPoint
    	p.writeInt( 1660 ); // m_nInitRatingPoint
    	p.writeInt( m_nELOType );
    	p.writeInt( m_nInitMatchTotalCount );
    	p.writeInt( m_nMatchTotalCount );
    	p.writeInt( m_nLastWinLose );
    	p.writeInt( m_nConstantK );
    	p.write( m_ucGrade );
    	p.writeInt( 7 ); // m_nPlacementTestPlayCount
    }
    
    public static void read_ELOUserDataPacketForDummy(Packet p) {
    	p.readInt(  ); // m_nInitELOWin
    	p.readInt(  ); // m_nELOWin
    	p.readInt(  ); // m_nInitELOLose
    	p.readInt(  ); // m_nELOLose
    	p.readInt(  ); // m_nRatingPoint
    	p.readInt(  ); // m_nInitRatingPoint
    	p.readInt(  ); // m_nELOType
    	p.readInt(  ); // m_nInitMatchTotalCount
    	p.readInt(  ); // m_nMatchTotalCount
    	p.readInt(  ); // m_nLastWinLose
    	p.readInt(  ); // m_nConstantK
    	p.readByte(  ); // m_ucGrade
    	p.readInt(); // m_nPlacementTestPlayCount
    }
}
