package com.magellans.cardtrading.generic.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.beans.Transient;
import java.util.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Condition {

    private Date fromDate;
    private Date toDate;

    private String orderByColumns;
    @Builder.Default
    private Boolean ascOrder = true;
    @Builder.Default
    private Integer firstItemIndex = 0;
    @Builder.Default
    private Integer maxItems = 0;
    @Builder.Default
    private Boolean exactMatch = true;


    @Builder.Default
    private Map<String, Object> params = new HashMap<>();
    @Builder.Default
    private Map<String, String> paramsOperator = new HashMap<>();
    @Builder.Default
    private List<CondItem> condItems = new ArrayList<>();

    public Condition with(String key, Object value) {
        params.put(key, value);
        condItems.add(new CondItem(key, null, value));
        return this;
    }

    public Condition with(String key, String operator, Object value) {
        params.put(key, value);
        paramsOperator.put(key, operator);
        condItems.add(new CondItem(key, operator, value));
        return this;
    }

    public Condition(String orderByColumns, Integer firstItemIndex, Integer maxItems) {
        super();
        this.orderByColumns = orderByColumns;
        this.firstItemIndex = (firstItemIndex == null) ? 0 : firstItemIndex;
        this.maxItems = (maxItems == null) ? 0 : maxItems;
        this.params = new HashMap<>();
        this.paramsOperator = new HashMap<>();
    }

    public Condition(String orderByColumns, Boolean ascOrder, Integer firstItemIndex, Integer maxItems) {
        super();
        this.orderByColumns = orderByColumns;
        this.ascOrder = (ascOrder == null) ? true : ascOrder;
        this.firstItemIndex = (firstItemIndex == null) ? 0 : firstItemIndex;
        this.maxItems = (maxItems == null) ? 0 : maxItems;
        this.params = new HashMap<>();
        this.paramsOperator = new HashMap<>();
    }

    public Condition(String orderByColumns, Boolean ascOrder, Integer firstItemIndex, Integer maxItems,
                     Boolean exactMatch) {
        super();
        this.orderByColumns = orderByColumns;
        this.ascOrder = (ascOrder == null) ? true : ascOrder;
        this.firstItemIndex = (firstItemIndex == null) ? 0 : firstItemIndex;
        this.maxItems = (maxItems == null) ? 0 : maxItems;
        this.exactMatch = (exactMatch == null) ? true : exactMatch;
        this.params = new HashMap<>();
        this.paramsOperator = new HashMap<>();
    }

    public Boolean getExactMatch() {
        return exactMatch;
    }

    public void setExactMatch(Boolean exactMatch) {
        this.exactMatch = exactMatch;
    }

    public void reSetCondition(String orderByColumns, Boolean ascOrder, Integer firstItemIndex, Integer maxItems,
                               Boolean exactMatch) {
        if (orderByColumns != null) {
            this.setOrderByColumns(orderByColumns);
        }
        if (ascOrder != null) {
            this.setAscOrder(ascOrder);
        }
        if (firstItemIndex != null) {
            this.setFirstItemIndex(firstItemIndex);
        }
        if (maxItems != null) {
            this.setMaxItems(maxItems);
        }
        if (exactMatch != null) {
            this.setExactMatch(exactMatch);
        }
    }

    public Date getFromDate() {
        if (containsKey("from_date")) {
            fromDate = getDateValue("from_date");
        }
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        if (containsKey("to_date")) {
            toDate = getDateValue("to_date");
        }
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getOrderByColumns() {
        if (containsKey("order_columns")) {
            orderByColumns = getStringValue("order_columns");
        }
        return orderByColumns;
    }

    public void setOrderByColumns(String orderByColumns) {
        this.orderByColumns = orderByColumns;
    }

    public Boolean isAscOrder() {
        if (ascOrder == null) {
            ascOrder = getBooleanValue("asc_order");
        }
        return ascOrder;
    }

    public Integer getFirstItemIndex() {
        if (containsKey("first_index")) {
            firstItemIndex = getIntValue("first_index");
        }
        return firstItemIndex;
    }

    public void setFirstItemIndex(Integer firstItemIndex) {
        this.firstItemIndex = firstItemIndex;
    }

    public Integer getMaxItems() {
        if (containsKey("max_items")) {
            maxItems = getIntValue("max_items");
        }
        return maxItems;
    }

    public void setMaxItems(Integer maxItems) {
        this.maxItems = maxItems;
    }

    public Boolean isExactMatch() {
        if (containsKey("exact_match")) {
            exactMatch = getBooleanValue("exact_match");
        }
        return exactMatch;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        if (params != null) {
            this.params = params;
        }
    }

    public boolean containsKey(String key) {
        return params.containsKey(key);
    }

    public Object get(String key) {
        return params.get(key);
    }

    public void add(String key, Object value) {
        if (!StringUtils.isEmpty(value)) {
            params.put(key, value);
        }
    }

    public void add(String key, String operator, Object value) {
        if (!StringUtils.isEmpty(value)) {
            params.put(key, value);
            paramsOperator.put(key, operator);
        }
    }

    public String getOperator(String key) {
        if (paramsOperator != null && paramsOperator.get(key) != null) {
            return paramsOperator.get(key);
        }
        return null;
    }

    public Integer getIntValue(String key) {
        if (params != null && params.get(key) != null) {
            return Integer.valueOf(params.get(key).toString());
        }
        return null;
    }

    @Transient
    public Long getLongValue(String key) {
        if (params != null && params.get(key) != null) {
            return Long.valueOf(params.get(key).toString());
        }
        return null;
    }

    @Transient
    public Double getDoubleValue(String key) {
        if (params != null && params.get(key) != null) {
            return Double.valueOf(params.get(key).toString());
        }
        return null;
    }

    @Transient
    public Float getFloatValue(String key) {
        if (params != null && params.get(key) != null) {
            return Float.valueOf(params.get(key).toString());
        }
        return null;
    }

    @Transient
    public String getStringValue(String key) {
        if (params != null && params.get(key) != null) {
            return (params.get(key) != null) ? params.get(key).toString().trim() : null;
        }
        return null;
    }

    @Transient
    public Date getDateValue(String key) {
        if (params != null && params.get(key) != null) {
            return (Date) params.get(key);
        }
        return null;
    }

    @Transient
    public Boolean getBooleanValue(String key) {
        return params != null && containsKey(key) && ("1".equals(getStringValue(key)) || "true".equals(getStringValue(key))
                || "TRUE".equals(getStringValue(key)));
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class CondItem {
        private String attributeName;
        private String operator;
        private Object value;
    }
}