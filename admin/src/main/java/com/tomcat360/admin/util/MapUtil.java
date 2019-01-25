package com.tomcat360.admin.util;

import java.util.Map;

public class MapUtil {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map joinDataEquipment(Map map) {
		if (map.get("equipmentType") == null) {
			map.put("equipmentType", null);
		}
		if (map.get("equipmentSubType") == null) {
			map.put("equipmentSubType", null);
		}
		if (map.get("equipmentVersion") == null) {
			map.put("equipmentVersion", null);
		}
		if (map.get("softVersion") == null) {
			map.put("softVersion", null);
		}
		if (map.get("brand") == null) {
			map.put("brand", null);
		}
		if (map.get("operateos") == null) {
			map.put("operateos", null);
		}
		if (map.get("browser") == null) {
			map.put("browser", null);
		}
		if (map.get("installLocation") == null) {
			map.put("installLocation", null);
		}
		if (map.get("preIp") == null) {
			map.put("preIp", null);
		}
		if (map.get("prePort") == null) {
			map.put("prePort", null);
		}
		if (map.get("monitorPort") == null) {
			map.put("monitorPort", null);
		}
		if (map.get("monitorFile") == null) {
			map.put("monitorFile", null);
		}
		if (map.get("versionServerPort") == null) {
			map.put("versionServerPort", null);
		}
		if (map.get("versionServerFilePort") == null) {
			map.put("versionServerFilePort", null);
		}
		if (map.get("localMonitorPort") == null) {
			map.put("localMonitorPort", null);
		}
		if (map.get("localFileMonitorPort") == null) {
			map.put("localFileMonitorPort", null);
		}
		if (map.get("limitPerDay") == null) {
			map.put("limitPerDay", null);
		}
		if (map.get("currencyCode") == null) {
			map.put("currencyCode", null);
		}
		if (map.get("masterKey") == null) {
			map.put("masterKey", null);
		}
		if (map.get("amount") == null) {
			map.put("amount", null);
		}
		if (map.get("privateKey") == null) {
			map.put("privateKey", null);
		}
		if (map.get("onlineTime") == null) {
			map.put("onlineTime", null);
		}
		if (map.get("useState") == null) {
			map.put("useState", null);
		}
		if (map.get("verifyStatus") == null) {
			map.put("verifyStatus", null);
		}
		if (map.get("countryId") == null) {
			map.put("countryId", null);
		}
		if (map.get("country") == null) {
			map.put("country", null);
		}
		if (map.get("secondRegionId") == null) {
			map.put("secondRegionId", null);
		}
		if (map.get("thirdRegionId") == null) {
			map.put("thirdRegionId", null);
		}
		if (map.get("fourthRegionId") == null) {
			map.put("fourthRegionId", null);
		}
		if (map.get("detailAddress") == null) {
			map.put("detailAddress", null);
		}
		if (map.get("createTime") == null) {
			map.put("createTime", null);
		}
		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map joinDataDowntimeEquipment(Map map) {
		if (map.get("downReason") == null) {
			map.put("downReason", null);
		}
		if (map.get("downTime") == null) {
			map.put("downTime", null);
		}
		if (map.get("recoveryTime") == null) {
			map.put("recoveryTime", null);
		}
		if (map.get("country") == null) {
			map.put("country", null);
		}
		if (map.get("detailAddress") == null) {
			map.put("detailAddress", null);
		}
		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map joinDataFaultEquipment(Map map) {
		if (map.get("equipmentId") == null) {
			map.put("equipmentId", null);
		}
		if (map.get("keyBordCount") == null) {
			map.put("keyBordCount", null);
		}
		if (map.get("tellerCount") == null) {
			map.put("tellerCount", null);
		}
		if (map.get("printerCount") == null) {
			map.put("printerCount", null);
		}
		if (map.get("country") == null) {
			map.put("country", null);
		}
		if (map.get("detailAddress") == null) {
			map.put("detailAddress", null);
		}
		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map joinDatalackMoneyEquipment(Map map) {
		if (map.get("equipmentId") == null) {
			map.put("equipmentId", null);
		}
		if (map.get("banknoteBoxCount") == null) {
			map.put("banknoteBoxCount", null);
		}
		if (map.get("printerCount") == null) {
			map.put("printerCount", null);
		}
		if (map.get("country") == null) {
			map.put("country", null);
		}
		if (map.get("detailAddress") == null) {
			map.put("detailAddress", null);
		}
		return map;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map joinDataVrsionEquipment(Map map) {
		if (map.get("preIp") == null) {
			map.put("preIp", null);
		}

		if (map.get("equipmentVersion") == null) {
			map.put("equipmentVersion", null);
		}

		if (map.get("softVersion") == null) {
			map.put("softVersion", null);
		}

		if (map.get("country") == null) {
			map.put("country", null);
		}
		
		if (map.get("detailAddress") == null) {
			map.put("detailAddress", null);
		}
		return map;
	}

}
