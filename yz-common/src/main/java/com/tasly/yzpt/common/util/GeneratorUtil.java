package com.tasly.yzpt.common.util;

import java.util.Arrays;
import org.apache.commons.lang.StringUtils;


public class GeneratorUtil {

  private static int checkDigits(int digits, String prefix, String suffix) {
    int prefixLength = 0;
    int suffixLength = 0;
    if (StringUtils.isNotBlank(prefix)) {
      prefixLength = prefix.length();
    }
    if (StringUtils.isNotBlank(suffix)) {
      suffixLength = suffix.length();
    }
    return digits - prefixLength - suffixLength;
  }

  /**
   * 对生成的数字进行精度补齐
   *
   * @param currentNumber 生成的数字
   */
  public static String getFormatted(Long currentNumber, int digits, String prefix, String suffix) {
    String ret = Long.toString(currentNumber);
    int s = ret.length();

    int checkDigits = checkDigits(digits, prefix, suffix);

    if (s < checkDigits) {
      char[] chars = new char[checkDigits];
      ret.getChars(0, s, chars, checkDigits - s);
      Arrays.fill(chars, 0, checkDigits - s, '0');
      ret = String.valueOf(chars);
    }

    return replaceSpecialCharacters(prefix, suffix, ret);
  }

  private static String replaceSpecialCharacters(String prefix, String suffix,
      String formattedNumber) {
    StringBuilder result = new StringBuilder();
    if (prefix != null) {
      result.append(prefix);
    }
    result.append(formattedNumber);
    if (suffix != null) {
      result.append(suffix);
    }
    return result.toString();
  }

}