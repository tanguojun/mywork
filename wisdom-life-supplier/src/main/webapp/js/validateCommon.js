/**
 * --------- 校验公共js -----------
 */

/**
 * 字符串长度是否在此中间(包含)
 * 
 * @param str
 * @param begin
 *            开始长度
 * @param end
 *            结束长度
 * @returns {Boolean}
 */
function isBettweenLength(str,begin,end){
	if (str.length >= begin && str.length <= end) {
		return true;
	}
	return false;
}

/**
 * 验证是否满足正则表达式
 * 
 * @param str
 * @param regu
 *            正则表达式
 * @returns {Boolean}
 */
function isPattern(str,regu){
	var re = new RegExp(regu);
	if (re.test(str)) {
		return true;
	}
	return false;
}