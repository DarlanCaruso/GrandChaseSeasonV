package login;

import java.util.Vector;

import client.LoginClient;
import game.GCEnum;
import packet.OpcodeLogin;
import packet.Packet;

public class ClientContentsOpen {
	public static class ChannelCategories {
		int ChNo;
		Vector<Integer> GameCategory;
		
		public ChannelCategories() {
			ChNo = -1;
			GameCategory = new Vector<Integer>();
		}
	} 
	
	public static class CategoryModes {
		int CategoryNo;
		Vector<Integer> GameMode;
		
		public CategoryModes() {
			CategoryNo = -1;
			GameMode = new Vector<Integer>();
		}
	}
	
	public static class CategoryInfo {
		int CategoryNo;
		boolean CanRandom;
		Vector<Integer> GameStage;
		
		public CategoryInfo() {
			CategoryNo = -1;
			CanRandom = false;
			GameStage = new Vector<Integer>();
		}
	}
	
	public static boolean isInit = false;
	public static Vector<ChannelCategories> m_vecChannelCategories = null;
	public static Vector<CategoryModes> m_vecCategoryModes = null;
	public static Vector<CategoryInfo> m_vecCategoryInfo = null;
	
	public static void init_CC() {
		m_vecChannelCategories = new Vector<ChannelCategories>();
		ChannelCategories cc;
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_DUNGEON;
		cc.GameCategory.add( GCEnum.GC_GMC_DUNGEON );
		m_vecChannelCategories.add(cc);
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_GUILD_UNLIMITED;
		cc.GameCategory.add( GCEnum.GC_GMC_GUILD_BATTLE );
		m_vecChannelCategories.add(cc);
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_GUILD_MASTER;
		cc.GameCategory.add( GCEnum.GC_GMC_GUILD_BATTLE );
		m_vecChannelCategories.add(cc);
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_GUILD_EXPERT;
		cc.GameCategory.add( GCEnum.GC_GMC_GUILD_BATTLE );
		m_vecChannelCategories.add(cc);
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_GUILD_ROOKIE;
		cc.GameCategory.add( GCEnum.GC_GMC_GUILD_BATTLE );
		m_vecChannelCategories.add(cc);
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_GUILD_BEGINNER;
		cc.GameCategory.add( GCEnum.GC_GMC_GUILD_BATTLE );
		m_vecChannelCategories.add(cc);
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_INDIGO;
		cc.GameCategory.add( GCEnum.GC_GMC_INDIGO );
		m_vecChannelCategories.add(cc);
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_UNLIMITED;
		cc.GameCategory.add( GCEnum.GC_GMC_MATCH );
		cc.GameCategory.add( GCEnum.GC_GMC_DEATHMATCH );
		cc.GameCategory.add( GCEnum.GC_GMC_ANGELS_EGG );
		cc.GameCategory.add( GCEnum.GC_GMC_CAPTAIN );
		cc.GameCategory.add( GCEnum.GC_GMC_DOTA );
		cc.GameCategory.add( GCEnum.GC_GMC_FATAL_DEATHMATCH );
		m_vecChannelCategories.add(cc);
		
		cc = new login.ClientContentsOpen.ChannelCategories();
		cc.ChNo = GCEnum.CT_AGIT;
		cc.GameCategory.add( GCEnum.GC_GMC_AGIT );
		m_vecChannelCategories.add(cc);
	}
	
	public static void init_CM() {
		m_vecCategoryModes = new Vector<CategoryModes>();
		CategoryModes cm;
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_MATCH;
		cm.GameMode.add( GCEnum.GC_GM_TEAM_MODE );
		cm.GameMode.add( GCEnum.GC_GM_SURVIVAL_MODE );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_GUILD_BATTLE;
		cm.GameMode.add( GCEnum.GC_GM_GUILD_BATTLE );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_INDIGO;
		cm.GameMode.add( GCEnum.GC_GM_INDIGO_TEAM );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_TUTORIAL;
		cm.GameMode.add( GCEnum.GC_GM_TUTORIAL );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_TAG_MATCH;
		cm.GameMode.add( GCEnum.GC_GM_TAG_TEAM );
		cm.GameMode.add( GCEnum.GC_GM_TAG_SURVIVAL );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_CAPTAIN;
		cm.GameMode.add( GCEnum.GC_GM_CAPTAIN );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_AGIT;
		cm.GameMode.add( GCEnum.GC_GM_AGIT );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_DOTA;
		cm.GameMode.add( GCEnum.GC_GM_DOTA );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_ANGELS_EGG;
		cm.GameMode.add( GCEnum.GC_GM_ANGELS_EGG );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_DEATHMATCH;
		cm.GameMode.add( GCEnum.GC_GM_DEATH_TEAM );
		cm.GameMode.add( GCEnum.GC_GM_DEATH_SURVIVAL );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_FATAL_DEATHMATCH;
		cm.GameMode.add( GCEnum.GC_GM_FATAL_DEATH_TEAM );
		cm.GameMode.add( GCEnum.GC_GM_FATAL_DEATH_SURVIVAL );
		m_vecCategoryModes.add(cm);
		
		cm = new login.ClientContentsOpen.CategoryModes();
		cm.CategoryNo = GCEnum.GC_GMC_DUNGEON;
		cm.GameMode.add( GCEnum.GC_GM_QUEST0 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST1 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST2 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST3 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST4 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST5 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST6 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST7 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST8 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST9 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST10 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST11 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST12 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST13 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST14 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST15 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST16 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST17 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST18 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST19 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST20 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST21 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST22 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST23 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST24 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST25 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST26 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST27 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST28 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST29 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST30 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST31 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST32 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST33 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST34 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST35 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST36 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST37 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST38 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST39 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST40 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST41 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST42 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST43 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST44 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST45 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST46 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST47 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST48 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST49 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST50 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST51 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST52 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST53 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST54 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST55 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST56 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST57 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST58 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST59 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST60 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST61 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST62 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST63 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST64 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST65 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST66 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST67 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST68 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST69 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST70 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST71 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST72 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST73 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST74 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST75 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST76 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST77 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST78 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST79 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST80 );
		cm.GameMode.add( GCEnum.GC_GM_QUEST81 );
		m_vecCategoryModes.add(cm);
	}
	
	public static void init_CI() {
		m_vecCategoryInfo = new Vector<CategoryInfo>();
		CategoryInfo ci;
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_TUTORIAL;
		ci.CanRandom = false;
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_MATCH;
		ci.CanRandom = true;
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_BAHIA ); 
		ci.GameStage.add( GCEnum.GC_GS_AMAZON_FOREST ); 
		ci.GameStage.add( GCEnum.GC_GS_MARKET_WATER ); 
		ci.GameStage.add( GCEnum.GC_GS_RIZAL_PARK ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF ); 
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY ); 
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE ); 
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD ); 
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE ); 
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_GUILD ); 
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_TRIAL ); 
		ci.GameStage.add( GCEnum.GC_GS_GRAVEYARD_OF_DECEASED );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_TAG_MATCH;
		ci.CanRandom = true;
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_BAHIA ); 
		ci.GameStage.add( GCEnum.GC_GS_AMAZON_FOREST ); 
		ci.GameStage.add( GCEnum.GC_GS_MARKET_WATER ); 
		ci.GameStage.add( GCEnum.GC_GS_RIZAL_PARK ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF ); 
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY ); 
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE ); 
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD ); 
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE ); 
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_GUILD ); 
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_TRIAL ); 
		ci.GameStage.add( GCEnum.GC_GS_GRAVEYARD_OF_DECEASED );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_CAPTAIN;
		ci.CanRandom = false;
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_BAHIA ); 
		ci.GameStage.add( GCEnum.GC_GS_AMAZON_FOREST ); 
		ci.GameStage.add( GCEnum.GC_GS_MARKET_WATER ); 
		ci.GameStage.add( GCEnum.GC_GS_RIZAL_PARK ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF ); 
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY ); 
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE ); 
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD ); 
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE ); 
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_GUILD ); 
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_TRIAL ); 
		ci.GameStage.add( GCEnum.GC_GS_GRAVEYARD_OF_DECEASED );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_DOTA;
		ci.CanRandom = true;
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_BAHIA ); 
		ci.GameStage.add( GCEnum.GC_GS_AMAZON_FOREST ); 
		ci.GameStage.add( GCEnum.GC_GS_MARKET_WATER ); 
		ci.GameStage.add( GCEnum.GC_GS_RIZAL_PARK ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF ); 
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY ); 
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE ); 
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD ); 
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE ); 
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_GUILD ); 
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_TRIAL ); 
		ci.GameStage.add( GCEnum.GC_GS_GRAVEYARD_OF_DECEASED );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_DEATHMATCH;
		ci.CanRandom = true;
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_BAHIA ); 
		ci.GameStage.add( GCEnum.GC_GS_AMAZON_FOREST ); 
		ci.GameStage.add( GCEnum.GC_GS_MARKET_WATER ); 
		ci.GameStage.add( GCEnum.GC_GS_RIZAL_PARK ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF ); 
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY ); 
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE ); 
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD ); 
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE ); 
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_GUILD ); 
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_TRIAL ); 
		ci.GameStage.add( GCEnum.GC_GS_GRAVEYARD_OF_DECEASED );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_FATAL_DEATHMATCH;
		ci.CanRandom = true;
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS ); 
		ci.GameStage.add( GCEnum.GC_GS_BAHIA ); 
		ci.GameStage.add( GCEnum.GC_GS_AMAZON_FOREST ); 
		ci.GameStage.add( GCEnum.GC_GS_MARKET_WATER ); 
		ci.GameStage.add( GCEnum.GC_GS_RIZAL_PARK ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF ); 
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP ); 
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY ); 
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE ); 
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD ); 
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE ); 
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_GUILD ); 
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH ); 
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_TRIAL ); 
		ci.GameStage.add( GCEnum.GC_GS_GRAVEYARD_OF_DECEASED );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_GUILD_BATTLE;
		ci.CanRandom = true;
		ci.GameStage.add( GCEnum.GC_GS_GUILD );
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS );
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS );
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF );
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP );
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH );
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY );
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE );
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD );
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_INDIGO;
		ci.CanRandom = true;
		ci.GameStage.add( GCEnum.GC_GS_GUILD );
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS );
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS );
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF );
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP );
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH );
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY );
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE );
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD );
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH );
		m_vecCategoryInfo.add(ci);
		
		ci = new login.ClientContentsOpen.CategoryInfo();
		ci.CategoryNo = GCEnum.GC_GMC_ANGELS_EGG;
		ci.CanRandom = true;
		ci.GameStage.add( GCEnum.GC_GS_GUILD );
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF_REVERS );
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH_REVERS );
		ci.GameStage.add( GCEnum.GC_GS_FOREST_OF_ELF );
		ci.GameStage.add( GCEnum.GC_GS_SWAMP_OF_OBLIVION );
		ci.GameStage.add( GCEnum.GC_GS_FLYING_SHIP );
		ci.GameStage.add( GCEnum.GC_GS_VALLEY_OF_OATH );
		ci.GameStage.add( GCEnum.GC_GS_FOGOTTEN_CITY );
		ci.GameStage.add( GCEnum.GC_GS_BABEL_OF_X_MAS );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_FIRE );
		ci.GameStage.add( GCEnum.GC_GS_SHOOTING_FIELD );
		ci.GameStage.add( GCEnum.GC_GS_HELL_BRIDGE );
		ci.GameStage.add( GCEnum.GC_GS_TEMPLE_OF_ORC );
		ci.GameStage.add( GCEnum.GC_GS_CARRIBEACH );
		m_vecCategoryInfo.add(ci);
	}
	
	public static void init() {
		// 채널별 카테고리 설정
		init_CC();
		
		// 카테고리별 모드 설정
		init_CM();
		
		// 카테고리별 랜덤/맵 설정
		init_CI();
		
		isInit = true;
	}
	
	public static void sendClientOpenContents(LoginClient c) {	
		if( isInit == false )
			init();
		
		Packet p = new Packet(OpcodeLogin.ENU_NEW_CLIENT_CONTENTS_OPEN_NOT);
		
		p.writeInt(0); // m_nSendType
		
		// m_prGameCategoryInfo
		p.writeInt(3); // pair - vector - size
		p.writeInt(0); p.writeInt(1); p.writeInt(2);
		
		// KCCGameCategoryInfo
		int vec_cc_size = m_vecChannelCategories.size();
		p.writeInt( vec_cc_size );
		for( int i=0; i<vec_cc_size; i++ ) {
			ChannelCategories cc = m_vecChannelCategories.get(i);
			p.writeInt(cc.ChNo);
			
			int vec_gc_size = cc.GameCategory.size();
			p.writeInt(vec_gc_size);
			for( int jj=0; jj<vec_gc_size; jj++ ) {
				p.writeInt( cc.GameCategory.get(jj) );
			}
		}
		
		int vec_cm_size = m_vecCategoryModes.size();
		p.writeInt( vec_cm_size );
		for( int i=0; i<vec_cm_size; i++ ) {
			CategoryModes cm = m_vecCategoryModes.get(i);
			p.writeInt(cm.CategoryNo);
			
			int vec_gm_size = cm.GameMode.size();
			p.writeInt(vec_gm_size);
			for( int jj=0; jj<vec_gm_size; jj++ ) {
				p.writeInt( cm.GameMode.get(jj) );
			}
		}
		
		int vec_ci_size = m_vecCategoryInfo.size();
		p.writeInt( vec_ci_size );
		for( int i=0; i<vec_ci_size; i++ ) {
			CategoryInfo ci = m_vecCategoryInfo.get(i);
			p.writeInt(ci.CategoryNo);
			p.writeBool(ci.CanRandom);
			
			int vec_gs_size = ci.GameStage.size();
			p.writeInt(vec_gs_size);
			for( int jj=0; jj<vec_gs_size; jj++ ) {
				p.writeInt( ci.GameStage.get(jj) );
			}
		}
		
		p.writeHexString("00 00 00 06 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 55 00 00 00 13 00 00 00 00 00 00 00 04 00 01 02 03 00 00 00 01 00 00 00 04 00 01 02 03 00 00 00 02 00 00 00 04 00 01 02 03 00 00 00 03 00 00 00 04 00 01 02 03 00 00 00 04 00 00 00 04 00 01 02 03 00 00 00 05 00 00 00 04 00 01 02 03 00 00 00 06 00 00 00 04 00 01 02 03 00 00 00 07 00 00 00 04 00 01 02 03 00 00 00 08 00 00 00 04 00 01 02 03 00 00 00 09 00 00 00 04 00 01 02 03 00 00 00 0A 00 00 00 04 00 01 02 03 00 00 00 0B 00 00 00 04 00 01 02 03 00 00 00 0C 00 00 00 04 00 01 02 03 00 00 00 0D 00 00 00 04 00 01 02 03 00 00 00 0E 00 00 00 04 00 01 02 03 00 00 00 0F 00 00 00 02 00 01 00 00 00 10 00 00 00 02 00 01 00 00 00 11 00 00 00 02 00 01 00 00 00 12 00 00 00 01 00 00 00 00 13 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 0C 00 00 00 0D 00 00 00 0E 00 00 00 0F 00 00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 00 00 00 00 00 00 02 00 00 00 01 00 00 00 02 00 00 00 02 00 00 00 02 00 00 00 03 00 00 00 01 00 00 00 04 00 00 00 01 00 00 00 05 00 00 00 01 00 00 00 06 00 00 00 01 00 00 00 07 00 00 00 01 00 00 00 08 00 00 00 01 00 00 00 09 00 00 00 01 00 00 00 0A 00 00 00 01 00 00 00 0B 00 00 00 01 00 00 00 0C 00 00 00 01 00 00 00 0D 00 00 00 01 00 00 00 0E 00 00 00 00 00 00 00 0F 00 00 00 01 00 00 00 10 00 00 00 01 00 00 00 11 00 00 00 00 00 00 00 12 00 00 00 00 00 00 00 12 00 00 00 00 00 01 83 3F 00 00 00 01 00 01 83 40 00 00 00 02 00 01 83 41 00 00 00 03 00 01 83 42 00 00 00 04 00 01 83 43 00 00 00 05 00 01 83 44 00 00 00 06 00 01 83 45 00 00 00 07 00 01 83 46 00 00 00 08 00 01 83 47 00 00 00 09 00 01 83 48 00 00 00 0A 00 01 83 49 00 00 00 0B 00 01 83 4A 00 00 00 0C 00 01 83 4B 00 00 00 0D 00 01 83 4C 00 00 00 0E 00 01 83 4D 00 00 00 0F 00 01 83 4E 00 00 00 10 00 01 83 4F 00 00 00 11 00 01 E3 32 00 00 00 43 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 0C 00 00 00 0D 00 00 00 0E 00 00 00 0F 00 00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 00 00 14 00 00 00 15 00 00 00 16 00 00 00 17 00 00 00 18 00 00 00 19 00 00 00 1A 00 00 00 1B 00 00 00 1C 00 00 00 1D 00 00 00 1E 00 00 00 1F 00 00 00 20 00 00 00 21 00 00 00 22 00 00 00 23 00 00 00 24 00 00 00 26 00 00 00 27 00 00 00 28 00 00 00 29 00 00 00 2A 00 00 00 2B 00 00 00 2C 00 00 00 2D 00 00 00 2E 00 00 00 2F 00 00 00 30 00 00 00 31 00 00 00 32 00 00 00 33 00 00 00 34 00 00 00 39 00 00 00 3A 00 00 00 3B 00 00 00 3C 00 00 00 3D 00 00 00 3E 00 00 00 3F 00 00 00 40 00 00 00 41 00 00 00 42 00 00 00 43 00 00 00 44 00 00 00 45 00 00 00 46 00 00 00 47 00 00 00 02 00 00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 00 00 00 13 00 00 00 18 00 00 00 03 00 00 22 56 00 00 00 8E 00 00 00 3C 74 00 65 00 78 00 5F 00 67 00 63 00 5F 00 6D 00 62 00 6F 00 78 00 5F 00 67 00 61 00 77 00 69 00 62 00 61 00 77 00 69 00 62 00 6F 00 5F 00 64 00 6C 00 67 00 2E 00 64 00 64 00 73 00 00 00 00 01 00 06 4E F6 00 00 25 40 00 00 00 B3 00 00 00 36 74 00 65 00 78 00 5F 00 67 00 63 00 5F 00 6D 00 62 00 6F 00 78 00 5F 00 66 00 72 00 69 00 65 00 6E 00 64 00 5F 00 67 00 69 00 66 00 74 00 2E 00 64 00 64 00 73 00 00 00 00 01 00 0C C5 D8 00 00 27 D2 00 00 00 BF 00 00 00 38 74 00 65 00 78 00 5F 00 67 00 63 00 5F 00 6D 00 62 00 6F 00 78 00 5F 00 73 00 6F 00 6E 00 67 00 6B 00 72 00 61 00 6E 00 5F 00 64 00 6C 00 67 00 2E 00 64 00 64 00 73 00 00 00 00 01 00 0D 5E 44");
		
		
		// 이터널 완전체
		//p.writeHexString("00 00 00 00 00 00 00 03 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 09 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 09 00 00 00 01 00 00 00 01 00 00 00 0A 00 00 00 01 00 00 00 01 00 00 00 0E 00 00 00 01 00 00 00 01 00 00 00 12 00 00 00 01 00 00 00 01 00 00 00 14 00 00 00 01 00 00 00 01 00 00 00 02 00 00 00 01 00 00 00 03 00 00 00 03 00 00 00 01 00 00 00 00 00 00 00 15 00 00 00 01 00 00 00 0D 00 00 00 08 00 00 00 00 00 00 00 02 00 00 00 01 00 00 00 02 00 00 00 01 00 00 00 01 00 00 00 05 00 00 00 03 00 00 00 01 00 00 00 06 00 00 00 04 00 00 00 01 00 00 00 00 00 00 00 05 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 02 00 00 00 42 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 0C 00 00 00 0D 00 00 00 0E 00 00 00 0F 00 00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 00 00 14 00 00 00 15 00 00 00 16 00 00 00 17 00 00 00 18 00 00 00 19 00 00 00 1A 00 00 00 1B 00 00 00 1E 00 00 00 24 00 00 00 27 00 00 00 28 00 00 00 29 00 00 00 2A 00 00 00 2B 00 00 00 2C 00 00 00 2D 00 00 00 2E 00 00 00 2F 00 00 00 30 00 00 00 31 00 00 00 32 00 00 00 37 00 00 00 38 00 00 00 39 00 00 00 3A 00 00 00 3B 00 00 00 3C 00 00 00 3D 00 00 00 3E 00 00 00 3F 00 00 00 40 00 00 00 46 00 00 00 49 00 00 00 4A 00 00 00 4C 00 00 00 4E 00 00 00 4F 00 00 00 50 00 00 00 51 00 00 00 53 00 00 00 54 00 00 00 55 00 00 00 56 00 00 00 57 00 00 00 58 00 00 00 59 00 00 00 5A 00 00 00 5B 00 00 00 5C 00 00 00 5D 00 00 00 5E 00 00 00 5F 00 00 00 0B 00 00 00 01 00 00 00 26 00 00 00 0D 00 00 00 01 00 00 00 42 00 00 00 06 00 00 00 04 00 00 00 00 01 00 00 00 63 00 00 00 00 01 00 00 00 10 00 00 00 63 00 00 00 64 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 2B 00 00 00 2F 00 00 00 01 01 00 00 00 0E 00 00 00 0A 00 00 00 63 00 00 00 64 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 09 00 00 00 04 00 00 00 06 00 00 00 05 00 00 00 08 00 00 00 07 00 00 00 0B 00 00 00 05 01 00 00 00 10 00 00 00 63 00 00 00 64 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 2B 00 00 00 2F 00 00 00 03 01 00 00 00 09 00 00 00 63 00 00 00 64 00 00 00 00 00 00 00 01 00 00 00 09 00 00 00 0B 00 00 00 02 00 00 00 0A 00 00 00 04 00 00 00 0B 00 00 00 00 10 00 00 00 63 00 00 00 64 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 2B 00 00 00 2F 00 00 00 06 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 55 00 00 00 13 00 00 00 00 00 00 00 04 00 01 02 03 00 00 00 01 00 00 00 04 00 01 02 03 00 00 00 02 00 00 00 04 00 01 02 03 00 00 00 03 00 00 00 04 00 01 02 03 00 00 00 04 00 00 00 04 00 01 02 03 00 00 00 05 00 00 00 04 00 01 02 03 00 00 00 06 00 00 00 04 00 01 02 03 00 00 00 07 00 00 00 04 00 01 02 03 00 00 00 08 00 00 00 04 00 01 02 03 00 00 00 09 00 00 00 04 00 01 02 03 00 00 00 0A 00 00 00 04 00 01 02 03 00 00 00 0B 00 00 00 04 00 01 02 03 00 00 00 0C 00 00 00 04 00 01 02 03 00 00 00 0D 00 00 00 04 00 01 02 03 00 00 00 0E 00 00 00 04 00 01 02 03 00 00 00 0F 00 00 00 02 00 01 00 00 00 10 00 00 00 02 00 01 00 00 00 11 00 00 00 02 00 01 00 00 00 12 00 00 00 01 00 00 00 00 13 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 0C 00 00 00 0D 00 00 00 0E 00 00 00 0F 00 00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 00 00 00 00 00 00 02 00 00 00 01 00 00 00 02 00 00 00 02 00 00 00 02 00 00 00 03 00 00 00 01 00 00 00 04 00 00 00 01 00 00 00 05 00 00 00 01 00 00 00 06 00 00 00 01 00 00 00 07 00 00 00 01 00 00 00 08 00 00 00 01 00 00 00 09 00 00 00 01 00 00 00 0A 00 00 00 01 00 00 00 0B 00 00 00 01 00 00 00 0C 00 00 00 01 00 00 00 0D 00 00 00 01 00 00 00 0E 00 00 00 00 00 00 00 0F 00 00 00 01 00 00 00 10 00 00 00 01 00 00 00 11 00 00 00 00 00 00 00 12 00 00 00 00 00 00 00 12 00 00 00 00 00 01 83 3F 00 00 00 01 00 01 83 40 00 00 00 02 00 01 83 41 00 00 00 03 00 01 83 42 00 00 00 04 00 01 83 43 00 00 00 05 00 01 83 44 00 00 00 06 00 01 83 45 00 00 00 07 00 01 83 46 00 00 00 08 00 01 83 47 00 00 00 09 00 01 83 48 00 00 00 0A 00 01 83 49 00 00 00 0B 00 01 83 4A 00 00 00 0C 00 01 83 4B 00 00 00 0D 00 01 83 4C 00 00 00 0E 00 01 83 4D 00 00 00 0F 00 01 83 4E 00 00 00 10 00 01 83 4F 00 00 00 11 00 01 E3 32 00 00 00 43 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 0C 00 00 00 0D 00 00 00 0E 00 00 00 0F 00 00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 00 00 14 00 00 00 15 00 00 00 16 00 00 00 17 00 00 00 18 00 00 00 19 00 00 00 1A 00 00 00 1B 00 00 00 1C 00 00 00 1D 00 00 00 1E 00 00 00 1F 00 00 00 20 00 00 00 21 00 00 00 22 00 00 00 23 00 00 00 24 00 00 00 26 00 00 00 27 00 00 00 28 00 00 00 29 00 00 00 2A 00 00 00 2B 00 00 00 2C 00 00 00 2D 00 00 00 2E 00 00 00 2F 00 00 00 30 00 00 00 31 00 00 00 32 00 00 00 33 00 00 00 34 00 00 00 39 00 00 00 3A 00 00 00 3B 00 00 00 3C 00 00 00 3D 00 00 00 3E 00 00 00 3F 00 00 00 40 00 00 00 41 00 00 00 42 00 00 00 43 00 00 00 44 00 00 00 45 00 00 00 46 00 00 00 47 00 00 00 02 00 00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 02 00 00 00 13 00 00 00 18 00 00 00 03 00 00 22 56 00 00 00 8E 00 00 00 3C 74 00 65 00 78 00 5F 00 67 00 63 00 5F 00 6D 00 62 00 6F 00 78 00 5F 00 67 00 61 00 77 00 69 00 62 00 61 00 77 00 69 00 62 00 6F 00 5F 00 64 00 6C 00 67 00 2E 00 64 00 64 00 73 00 00 00 00 01 00 06 4E F6 00 00 25 40 00 00 00 B3 00 00 00 36 74 00 65 00 78 00 5F 00 67 00 63 00 5F 00 6D 00 62 00 6F 00 78 00 5F 00 66 00 72 00 69 00 65 00 6E 00 64 00 5F 00 67 00 69 00 66 00 74 00 2E 00 64 00 64 00 73 00 00 00 00 01 00 0C C5 D8 00 00 27 D2 00 00 00 BF 00 00 00 38 74 00 65 00 78 00 5F 00 67 00 63 00 5F 00 6D 00 62 00 6F 00 78 00 5F 00 73 00 6F 00 6E 00 67 00 6B 00 72 00 61 00 6E 00 5F 00 64 00 6C 00 67 00 2E 00 64 00 64 00 73 00 00 00 00 01 00 0D 5E 44");
		
		// 시즌5 완전체
		//p.writeHexString("00 00 00 00 00 00 00 03 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 0C 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 01 00 00 00 01 00 00 00 01 00 00 00 02 00 00 00 01 00 00 00 03 00 00 00 03 00 00 00 02 00 00 00 00 00 00 00 08 00 00 00 08 00 00 00 01 00 00 00 09 00 00 00 15 00 00 00 01 00 00 00 0D 00 00 00 09 00 00 00 01 00 00 00 01 00 00 00 0A 00 00 00 01 00 00 00 01 00 00 00 0E 00 00 00 01 00 00 00 01 00 00 00 12 00 00 00 01 00 00 00 01 00 00 00 14 00 00 00 01 00 00 00 01 00 00 00 16 00 00 00 01 00 00 00 0E 00 00 00 0B 00 00 00 00 00 00 00 02 00 00 00 01 00 00 00 02 00 00 00 01 00 00 00 01 00 00 00 05 00 00 00 03 00 00 00 01 00 00 00 06 00 00 00 04 00 00 00 01 00 00 00 00 00 00 00 05 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 07 00 00 00 01 00 00 00 1D 00 00 00 08 00 00 00 02 00 00 00 1F 00 00 00 20 00 00 00 02 00 00 00 46 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 0C 00 00 00 0D 00 00 00 0E 00 00 00 0F 00 00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 00 00 14 00 00 00 15 00 00 00 16 00 00 00 17 00 00 00 18 00 00 00 19 00 00 00 1A 00 00 00 1B 00 00 00 1E 00 00 00 24 00 00 00 27 00 00 00 28 00 00 00 29 00 00 00 2A 00 00 00 2B 00 00 00 2C 00 00 00 2F 00 00 00 2D 00 00 00 2E 00 00 00 30 00 00 00 31 00 00 00 32 00 00 00 37 00 00 00 38 00 00 00 39 00 00 00 3A 00 00 00 3B 00 00 00 3C 00 00 00 3D 00 00 00 3E 00 00 00 3F 00 00 00 40 00 00 00 45 00 00 00 46 00 00 00 49 00 00 00 4A 00 00 00 4C 00 00 00 4E 00 00 00 4F 00 00 00 50 00 00 00 51 00 00 00 54 00 00 00 55 00 00 00 56 00 00 00 57 00 00 00 58 00 00 00 59 00 00 00 5A 00 00 00 5B 00 00 00 5C 00 00 00 5D 00 00 00 5E 00 00 00 5F 00 00 00 62 00 00 00 63 00 00 00 64 00 00 00 65 00 00 00 09 00 00 00 02 00 00 00 21 00 00 00 22 00 00 00 0D 00 00 00 01 00 00 00 42 00 00 00 0E 00 00 00 01 00 00 00 4D 00 00 00 0C 00 00 00 04 00 00 00 00 01 00 00 00 00 00 00 00 00 01 00 00 00 10 00 00 00 03 00 00 00 00 00 00 00 63 00 00 00 0A 00 00 00 08 00 00 00 64 00 00 00 02 00 00 00 07 00 00 00 04 00 00 00 05 00 00 00 01 00 00 00 06 00 00 00 0B 00 00 00 09 00 00 00 2B 00 00 00 2F 00 00 00 01 01 00 00 00 0C 00 00 00 0A 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 09 00 00 00 04 00 00 00 06 00 00 00 05 00 00 00 08 00 00 00 07 00 00 00 0B 00 00 00 05 01 00 00 00 10 00 00 00 63 00 00 00 64 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 2B 00 00 00 2F 00 00 00 03 01 00 00 00 06 00 00 00 00 00 00 00 01 00 00 00 09 00 00 00 0B 00 00 00 02 00 00 00 0A 00 00 00 08 01 00 00 00 0F 00 00 00 03 00 00 00 00 00 00 00 63 00 00 00 0A 00 00 00 08 00 00 00 64 00 00 00 02 00 00 00 07 00 00 00 04 00 00 00 01 00 00 00 06 00 00 00 0B 00 00 00 09 00 00 00 2B 00 00 00 2F 00 00 00 0B 00 00 00 00 0D 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 2B 00 00 00 2F 00 00 00 0A 00 00 00 00 02 00 00 00 00 00 00 00 0A 00 00 00 06 00 00 00 00 01 00 00 00 00 00 00 00 0C 00 00 00 00 01 00 00 00 00 00 00 00 0E 01 00 00 00 05 00 00 00 63 00 00 00 00 00 00 00 03 00 00 00 08 00 00 00 0A 00 00 00 0F 01 00 00 00 10 00 00 00 03 00 00 00 00 00 00 00 63 00 00 00 0A 00 00 00 08 00 00 00 64 00 00 00 02 00 00 00 07 00 00 00 04 00 00 00 05 00 00 00 01 00 00 00 06 00 00 00 0B 00 00 00 09 00 00 00 2B 00 00 00 2F 00 00 00 06 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 55 00 00 00 14 00 00 00 00 00 00 00 04 00 01 02 03 00 00 00 01 00 00 00 04 00 01 02 03 00 00 00 02 00 00 00 04 00 01 02 03 00 00 00 03 00 00 00 04 00 01 02 03 00 00 00 04 00 00 00 04 00 01 02 03 00 00 00 05 00 00 00 04 00 01 02 03 00 00 00 06 00 00 00 04 00 01 02 03 00 00 00 07 00 00 00 04 00 01 02 03 00 00 00 08 00 00 00 04 00 01 02 03 00 00 00 09 00 00 00 04 00 01 02 03 00 00 00 0A 00 00 00 04 00 01 02 03 00 00 00 0B 00 00 00 04 00 01 02 03 00 00 00 0C 00 00 00 04 00 01 02 03 00 00 00 0D 00 00 00 04 00 01 02 03 00 00 00 0E 00 00 00 04 00 01 02 03 00 00 00 0F 00 00 00 02 00 01 00 00 00 10 00 00 00 02 00 01 00 00 00 11 00 00 00 02 00 01 00 00 00 12 00 00 00 01 00 00 00 00 13 00 00 00 01 00 00 00 00 14 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 0C 00 00 00 0D 00 00 00 0E 00 00 00 0F 00 00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 00 00 14 00 00 00 00 00 00 00 02 00 00 00 01 00 00 00 02 00 00 00 02 00 00 00 02 00 00 00 03 00 00 00 01 00 00 00 04 00 00 00 01 00 00 00 05 00 00 00 01 00 00 00 06 00 00 00 01 00 00 00 07 00 00 00 01 00 00 00 08 00 00 00 00 00 00 00 09 00 00 00 01 00 00 00 0A 00 00 00 01 00 00 00 0B 00 00 00 01 00 00 00 0C 00 00 00 01 00 00 00 0D 00 00 00 00 00 00 00 0E 00 00 00 00 00 00 00 0F 00 00 00 00 00 00 00 10 00 00 00 00 00 00 00 11 00 00 00 00 00 00 00 12 00 00 00 00 00 00 00 13 00 00 00 00 00 00 00 14 00 00 00 00 00 01 83 3F 00 00 00 01 00 01 83 40 00 00 00 02 00 01 83 41 00 00 00 03 00 01 83 42 00 00 00 04 00 01 83 43 00 00 00 05 00 01 83 44 00 00 00 06 00 01 83 45 00 00 00 07 00 01 83 46 00 00 00 08 00 01 83 47 00 00 00 09 00 01 83 48 00 00 00 0A 00 01 83 49 00 00 00 0B 00 01 83 4A 00 00 00 0C 00 01 83 4B 00 00 00 0D 00 01 83 4C 00 00 00 0E 00 01 83 4D 00 00 00 0F 00 01 83 4E 00 00 00 10 00 01 83 4F 00 00 00 11 00 01 E3 32 00 00 00 12 00 01 E4 47 00 00 00 13 00 01 E4 47 00 00 00 4A 00 00 00 00 00 00 00 01 00 00 00 02 00 00 00 03 00 00 00 04 00 00 00 05 00 00 00 06 00 00 00 07 00 00 00 08 00 00 00 09 00 00 00 0A 00 00 00 0B 00 00 00 0C 00 00 00 0D 00 00 00 0E 00 00 00 0F 00 00 00 10 00 00 00 11 00 00 00 12 00 00 00 13 00 00 00 14 00 00 00 15 00 00 00 16 00 00 00 17 00 00 00 18 00 00 00 19 00 00 00 1A 00 00 00 1B 00 00 00 1C 00 00 00 1D 00 00 00 1E 00 00 00 1F 00 00 00 20 00 00 00 21 00 00 00 22 00 00 00 23 00 00 00 24 00 00 00 25 00 00 00 26 00 00 00 27 00 00 00 28 00 00 00 29 00 00 00 2A 00 00 00 2B 00 00 00 2C 00 00 00 2D 00 00 00 2E 00 00 00 2F 00 00 00 30 00 00 00 31 00 00 00 32 00 00 00 33 00 00 00 34 00 00 00 35 00 00 00 36 00 00 00 3A 00 00 00 3B 00 00 00 3C 00 00 00 3D 00 00 00 3E 00 00 00 3F 00 00 00 40 00 00 00 41 00 00 00 42 00 00 00 43 00 00 00 44 00 00 00 45 00 00 00 46 00 00 00 47 00 00 00 48 00 00 00 49 00 00 00 4A 00 00 00 4E 00 00 00 4F 00 00 00 02 00 00 00 00 00 00 00 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 01 00 00 00 13 00 00 00 00");
		
		c.sendPacket(p, true);
	}
}
