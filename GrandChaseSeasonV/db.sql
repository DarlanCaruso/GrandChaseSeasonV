-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.36-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- gc 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `gc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gc`;

-- 테이블 gc.account 구조 내보내기
CREATE TABLE IF NOT EXISTS `account` (
  `LoginUID` int(11) NOT NULL AUTO_INCREMENT,
  `Login` varchar(20) NOT NULL,
  `Passwd` varchar(32) NOT NULL,
  `Nick` varchar(20) DEFAULT NULL,
  `GamePoint` int(11) NOT NULL DEFAULT '1000',
  `VP` int(11) NOT NULL DEFAULT '0',
  `AuthLevel` int(11) NOT NULL DEFAULT '0',
  `InvenCapacity` int(11) NOT NULL DEFAULT '200',
  `BonusPoint` int(11) NOT NULL DEFAULT '10',
  `SpecialBonusPoint` int(11) NOT NULL DEFAULT '0',
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`LoginUID`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.attend 구조 내보내기
CREATE TABLE IF NOT EXISTS `attend` (
  `LoginUID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `AccTime` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.character 구조 내보내기
CREATE TABLE IF NOT EXISTS `character` (
  `LoginUID` int(11) NOT NULL,
  `CharType` int(11) NOT NULL,
  `Promotion` int(11) NOT NULL,
  `Exp` int(11) NOT NULL,
  `Level` int(11) NOT NULL,
  `RegDate` datetime NOT NULL,
  `Win` int(11) NOT NULL DEFAULT '0',
  `Lose` int(11) NOT NULL DEFAULT '0',
  `SkillPoint` int(11) NOT NULL DEFAULT '0',
  `MaxSkillPoint` int(11) NOT NULL DEFAULT '0',
  `PetUID` int(11) NOT NULL DEFAULT '0',
  `WeaponChange` int(11) NOT NULL DEFAULT '0',
  `WeaponChangeUID` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`LoginUID`,`CharType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.equipment 구조 내보내기
CREATE TABLE IF NOT EXISTS `equipment` (
  `LoginUID` int(11) NOT NULL,
  `CharType` int(11) NOT NULL,
  `ItemUID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.gameserver 구조 내보내기
CREATE TABLE IF NOT EXISTS `gameserver` (
  `ID` int(11) NOT NULL,
  `ServerName` varchar(50) NOT NULL,
  `ServerDesc` varchar(50) NOT NULL,
  `IP` varchar(15) NOT NULL,
  `Port` int(11) NOT NULL,
  `ServerTypeFlag` int(11) NOT NULL,
  `Show` int(11) NOT NULL,
  `Order` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.goodsinfo 구조 내보내기
CREATE TABLE IF NOT EXISTS `goodsinfo` (
  `ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Desc` varchar(200) NOT NULL,
  `CharType` tinyint(4) NOT NULL DEFAULT '-1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.inventory 구조 내보내기
CREATE TABLE IF NOT EXISTS `inventory` (
  `ItemUID` bigint(20) NOT NULL AUTO_INCREMENT,
  `LoginUID` int(11) NOT NULL,
  `ItemID` int(11) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Period` int(11) NOT NULL,
  `Grade` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ItemUID`)
) ENGINE=InnoDB AUTO_INCREMENT=21936 DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.inventory_attribute 구조 내보내기
CREATE TABLE IF NOT EXISTS `inventory_attribute` (
  `ItemUID` int(11) NOT NULL,
  `SlotID` int(11) NOT NULL,
  `Type` int(11) NOT NULL,
  `State` int(11) NOT NULL,
  `Value` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.inventory_socket 구조 내보내기
CREATE TABLE IF NOT EXISTS `inventory_socket` (
  `ItemUID` bigint(20) NOT NULL,
  `CardItemID` int(11) NOT NULL,
  `SlotID` int(11) NOT NULL,
  `State` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.mission 구조 내보내기
CREATE TABLE IF NOT EXISTS `mission` (
  `LoginUID` int(11) NOT NULL,
  `MissionItemID` int(11) NOT NULL,
  `RegDate` datetime NOT NULL,
  `EndDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.pet 구조 내보내기
CREATE TABLE IF NOT EXISTS `pet` (
  `PetUID` bigint(20) NOT NULL,
  `LoginUID` int(11) NOT NULL,
  `PetItemID` int(11) NOT NULL,
  `Exp` int(11) NOT NULL DEFAULT '0',
  `Level` int(11) NOT NULL DEFAULT '0',
  `Promotion` int(11) NOT NULL DEFAULT '0',
  `Health` int(11) NOT NULL DEFAULT '6000',
  `Name` varchar(50) NOT NULL,
  `Slot1` bigint(20) NOT NULL DEFAULT '0',
  `Slot2` bigint(20) NOT NULL DEFAULT '0',
  `Bind` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`PetUID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.shop 구조 내보내기
CREATE TABLE IF NOT EXISTS `shop` (
  `StartID` int(11) NOT NULL,
  `EndID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
-- 테이블 gc.skill 구조 내보내기
CREATE TABLE IF NOT EXISTS `skill` (
  `LoginUID` int(11) NOT NULL,
  `CharType` int(11) NOT NULL,
  `CharPromotion` int(11) NOT NULL,
  `SkillSetID` int(11) NOT NULL,
  `SlotIndex` int(11) NOT NULL,
  `SlotID` int(11) NOT NULL,
  `SkillID` int(11) NOT NULL
) ENGINE=CSV DEFAULT CHARSET=utf8;

-- 내보낼 데이터가 선택되어 있지 않습니다.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
