package com.transcendence.core.utils.appinfo.format;


import com.transcendence.core.utils.appinfo.BigDecimalUtils;
import com.transcendence.core.utils.appinfo.NumberUtils;

/**
 * detail: 单位数组范围格式化
 * @author Ttt
 */
public class UnitSpanFormatter {

    // 单位格式化精度
    private final int     precision;
    // 是否自动补 0 ( 只有 int、long 有效 )
    private final boolean appendZero;
    // 格式化异常默认值
    private final String  defaultValue;

    /**
     * 构造函数
     * @param precision    单位格式化精度
     * @param appendZero   是否自动补 0 ( 只有 int、long 有效 )
     * @param defaultValue 格式化异常默认值
     */
    public UnitSpanFormatter(
            final int precision,
            final boolean appendZero,
            final String defaultValue
    ) {
        this.precision    = precision;
        this.appendZero   = appendZero;
        this.defaultValue = defaultValue;
    }

    // =============
    // = 对外公开方法 =
    // =============

    /**
     * 获取 UnitSpanFormatter
     * @param precision 单位格式化精度
     * @return {@link UnitSpanFormatter}
     */
    public static UnitSpanFormatter get(
            final int precision
    ) {
        return new UnitSpanFormatter(precision, false, null);
    }

    /**
     * 获取 UnitSpanFormatter
     * @param precision    单位格式化精度
     * @param defaultValue 格式化异常默认值
     * @return {@link UnitSpanFormatter}
     */
    public static UnitSpanFormatter get(
            final int precision,
            final String defaultValue
    ) {
        return new UnitSpanFormatter(precision, false, defaultValue);
    }

    /**
     * 获取 UnitSpanFormatter
     * @param precision  单位格式化精度
     * @param appendZero 是否自动补 0 ( 只有 int、long 有效 )
     * @return {@link UnitSpanFormatter}
     */
    public static UnitSpanFormatter get(
            final int precision,
            final boolean appendZero
    ) {
        return new UnitSpanFormatter(precision, appendZero, null);
    }

    /**
     * 获取 UnitSpanFormatter
     * @param precision    单位格式化精度
     * @param appendZero   是否自动补 0 ( 只有 int、long 有效 )
     * @param defaultValue 格式化异常默认值
     * @return {@link UnitSpanFormatter}
     */
    public static UnitSpanFormatter get(
            final int precision,
            final boolean appendZero,
            final String defaultValue
    ) {
        return new UnitSpanFormatter(precision, appendZero, defaultValue);
    }

    // =======
    // = get =
    // =======

    /**
     * 获取单位格式化精度
     * @return 单位格式化精度
     */
    public int getPrecision() {
        return precision;
    }

    /**
     * 是否自动补 0
     * @return {@code true} yes, {@code false} no
     */
    public boolean isAppendZero() {
        return appendZero;
    }

    /**
     * 获取格式化异常默认值
     * @return 格式化异常默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    // ============
    // = 格式化方法 =
    // ============

    // ==========
    // = double =
    // ==========

    /**
     * 格式化
     * @param values 待格式化值
     * @param units  对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String format(
            final double[] values,
            final String[] units
    ) {
        return format(values, units, null);
    }

    /**
     * 格式化
     * @param values    待格式化值
     * @param units     对应值单位
     * @param operation BigDecimal 操作包装类
     * @return 单位数组范围格式化字符串
     */
    public String format(
            final double[] values,
            final String[] units,
            final BigDecimalUtils.Operation operation
    ) {
        if (precision > 0 && values != null && units != null) {
            if (precision <= values.length && precision <= units.length) {
                BigDecimalUtils.Operation op = null;
                if (operation != null) op = operation.clone();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < precision; i++) {
                    if (op != null) {
                        String value = op.setBigDecimal(values[i]).round()
                                .toPlainString();
                        builder.append(value);
                    } else {
                        builder.append(values[i]);
                    }
                    builder.append(units[i]);
                }
                return builder.toString();
            }
        }
        return defaultValue;
    }

    // =========
    // = float =
    // =========

    /**
     * 格式化
     * @param values 待格式化值
     * @param units  对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String format(
            final float[] values,
            final String[] units
    ) {
        return format(values, units, null);
    }

    /**
     * 格式化
     * @param values    待格式化值
     * @param units     对应值单位
     * @param operation BigDecimal 操作包装类
     * @return 单位数组范围格式化字符串
     */
    public String format(
            final float[] values,
            final String[] units,
            final BigDecimalUtils.Operation operation
    ) {
        if (precision > 0 && values != null && units != null) {
            if (precision <= values.length && precision <= units.length) {
                BigDecimalUtils.Operation op = null;
                if (operation != null) op = operation.clone();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < precision; i++) {
                    if (op != null) {
                        String value = op.setBigDecimal(values[i]).round()
                                .toPlainString();
                        builder.append(value);
                    } else {
                        builder.append(values[i]);
                    }
                    builder.append(units[i]);
                }
                return builder.toString();
            }
        }
        return defaultValue;
    }

    // ========
    // = long =
    // ========

    /**
     * 格式化
     * @param values 待格式化值
     * @param units  对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String format(
            final long[] values,
            final String[] units
    ) {
        if (precision > 0 && values != null && units != null) {
            if (precision <= values.length && precision <= units.length) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < precision; i++) {
                    long value = values[i];
                    builder.append(NumberUtils.addZero(value, appendZero))
                            .append(units[i]);
                }
                return builder.toString();
            }
        }
        return defaultValue;
    }

    // =======
    // = int =
    // =======

    /**
     * 格式化
     * @param values 待格式化值
     * @param units  对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String format(
            final int[] values,
            final String[] units
    ) {
        if (precision > 0 && values != null && units != null) {
            if (precision <= values.length && precision <= units.length) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < precision; i++) {
                    long value = values[i];
                    builder.append(NumberUtils.addZero(value, appendZero))
                            .append(units[i]);
                }
                return builder.toString();
            }
        }
        return defaultValue;
    }

    // ===========
    // = Generic =
    // ===========

    /**
     * 格式化
     * @param values 待格式化值
     * @param units  对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String format(
            final Object[] values,
            final String[] units
    ) {
        if (precision > 0 && values != null && units != null) {
            if (precision <= values.length && precision <= units.length) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < precision; i++) {
                    builder.append(values[i])
                            .append(units[i]);
                }
                return builder.toString();
            }
        }
        return defaultValue;
    }

    // =============
    // = Unit Span =
    // =============

    // ==========
    // = double =
    // ==========

    /**
     * 计算指定单位倍数格式化
     * @param value     待格式化值
     * @param unitSpans 对应单位范围
     * @param units     对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String formatBySpan(
            final double value,
            final double[] unitSpans,
            final String[] units
    ) {
        return formatBySpan(value, unitSpans, units, null);
    }

    /**
     * 计算指定单位倍数格式化
     * @param value     待格式化值
     * @param unitSpans 对应单位范围
     * @param units     对应值单位
     * @param operation BigDecimal 操作包装类
     * @return 单位数组范围格式化字符串
     */
    public String formatBySpan(
            final double value,
            final double[] unitSpans,
            final String[] units,
            final BigDecimalUtils.Operation operation
    ) {
        if (unitSpans != null && units != null) {
            double[] values = NumberUtils.calculateUnitD(value, unitSpans);
            return format(values, units, operation);
        }
        return defaultValue;
    }

    // =========
    // = float =
    // =========

    /**
     * 计算指定单位倍数格式化
     * @param value     待格式化值
     * @param unitSpans 对应单位范围
     * @param units     对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String formatBySpan(
            final float value,
            final float[] unitSpans,
            final String[] units
    ) {
        return formatBySpan(value, unitSpans, units, null);
    }

    /**
     * 计算指定单位倍数格式化
     * @param value     待格式化值
     * @param unitSpans 对应单位范围
     * @param units     对应值单位
     * @param operation BigDecimal 操作包装类
     * @return 单位数组范围格式化字符串
     */
    public String formatBySpan(
            final float value,
            final float[] unitSpans,
            final String[] units,
            final BigDecimalUtils.Operation operation
    ) {
        if (unitSpans != null && units != null) {
            float[] values = NumberUtils.calculateUnitF(value, unitSpans);
            return format(values, units, operation);
        }
        return defaultValue;
    }

    // ========
    // = long =
    // ========

    /**
     * 计算指定单位倍数格式化
     * @param value     待格式化值
     * @param unitSpans 对应单位范围
     * @param units     对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String formatBySpan(
            final long value,
            final long[] unitSpans,
            final String[] units
    ) {
        if (unitSpans != null && units != null) {
            long[] values = NumberUtils.calculateUnitL(value, unitSpans);
            return format(values, units);
        }
        return defaultValue;
    }

    // =======
    // = int =
    // =======

    /**
     * 计算指定单位倍数格式化
     * @param value     待格式化值
     * @param unitSpans 对应单位范围
     * @param units     对应值单位
     * @return 单位数组范围格式化字符串
     */
    public String formatBySpan(
            final int value,
            final int[] unitSpans,
            final String[] units
    ) {
        if (unitSpans != null && units != null) {
            int[] values = NumberUtils.calculateUnitI(value, unitSpans);
            return format(values, units);
        }
        return defaultValue;
    }
}