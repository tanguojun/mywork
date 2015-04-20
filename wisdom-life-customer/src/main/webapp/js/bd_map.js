/**
 * bd_map core
 */

/**
 * 设置地图显示的城市
 * 
 * @param map
 *            地图对象
 * @param currentCity
 *            显示的城市
 */
function setCurrentCity(map, currentCity) {
	map.setCurrentCity(currentCity);
	return map;
}

/**
 * 设置地图缩放级别
 * 
 * @param map
 * @param zoom
 * @returns
 */
function setZoom(map, zoom) {
	map.setZoom(zoom);
	return map;
}

/**
 * 设置中心点
 * 
 * @param map
 * @param longitude
 *            经度
 * @param latitude
 *            纬度
 */
function setCenter(map, longitude, latitude) {
	map.setCenter(new BMap.Point(longitude, latitude));
	return map;
}

/**
 * 设置中心点坐标和地图级别
 * 
 * @param map
 *            地图对象
 */
function setCenterAndZoom(map, longitude, latitude, zoom) {
	setCenter(map, longitude, latitude);
	setZoom(map, zoom);
}

/**
 * 
 * @param id
 * @param currentCity
 *            设置地图显示的城市
 * @param enableScrollWheelZoom
 *            是否开启鼠标滚轮缩放
 * @returns {BMap.Map}
 */
function init(id, currentCity, enableScrollWheelZoom, longitude, latitude, zoom) {
	// 创建Map实例
	var map = new BMap.Map(id);
	// 初始化地图,设置中心点坐标和地图级别
	setCenterAndZoom(map, longitude, latitude, zoom);
	map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);
	map.addControl(new BMap.MapTypeControl()); // 添加地图类型控件
	// 设置地图显示的城市 此项是必须设置的
	setCurrentCity(map, currentCity);
	map.enableScrollWheelZoom(enableScrollWheelZoom); // 开启鼠标滚轮缩放
	return map;
}

