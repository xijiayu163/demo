package com.yu.study.dao.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileInfoPoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Integer limitStart;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Integer limitEnd;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public FileInfoPoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Integer getLimitStart() {
        return limitStart;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFileInfoUidIsNull() {
            addCriterion("file_info_uid is null");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidIsNotNull() {
            addCriterion("file_info_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidEqualTo(String value) {
            addCriterion("file_info_uid =", value, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidNotEqualTo(String value) {
            addCriterion("file_info_uid <>", value, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidGreaterThan(String value) {
            addCriterion("file_info_uid >", value, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidGreaterThanOrEqualTo(String value) {
            addCriterion("file_info_uid >=", value, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidLessThan(String value) {
            addCriterion("file_info_uid <", value, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidLessThanOrEqualTo(String value) {
            addCriterion("file_info_uid <=", value, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidLike(String value) {
            addCriterion("file_info_uid like", value, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidNotLike(String value) {
            addCriterion("file_info_uid not like", value, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidIn(List<String> values) {
            addCriterion("file_info_uid in", values, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidNotIn(List<String> values) {
            addCriterion("file_info_uid not in", values, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidBetween(String value1, String value2) {
            addCriterion("file_info_uid between", value1, value2, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidNotBetween(String value1, String value2) {
            addCriterion("file_info_uid not between", value1, value2, "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Long value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Long value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Long value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Long value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Long> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Long> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Long value1, Long value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileExtentionIsNull() {
            addCriterion("file_extention is null");
            return (Criteria) this;
        }

        public Criteria andFileExtentionIsNotNull() {
            addCriterion("file_extention is not null");
            return (Criteria) this;
        }

        public Criteria andFileExtentionEqualTo(String value) {
            addCriterion("file_extention =", value, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionNotEqualTo(String value) {
            addCriterion("file_extention <>", value, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionGreaterThan(String value) {
            addCriterion("file_extention >", value, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionGreaterThanOrEqualTo(String value) {
            addCriterion("file_extention >=", value, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionLessThan(String value) {
            addCriterion("file_extention <", value, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionLessThanOrEqualTo(String value) {
            addCriterion("file_extention <=", value, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionLike(String value) {
            addCriterion("file_extention like", value, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionNotLike(String value) {
            addCriterion("file_extention not like", value, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionIn(List<String> values) {
            addCriterion("file_extention in", values, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionNotIn(List<String> values) {
            addCriterion("file_extention not in", values, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionBetween(String value1, String value2) {
            addCriterion("file_extention between", value1, value2, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andFileExtentionNotBetween(String value1, String value2) {
            addCriterion("file_extention not between", value1, value2, "fileExtention");
            return (Criteria) this;
        }

        public Criteria andUploaderIsNull() {
            addCriterion("uploader is null");
            return (Criteria) this;
        }

        public Criteria andUploaderIsNotNull() {
            addCriterion("uploader is not null");
            return (Criteria) this;
        }

        public Criteria andUploaderEqualTo(String value) {
            addCriterion("uploader =", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotEqualTo(String value) {
            addCriterion("uploader <>", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderGreaterThan(String value) {
            addCriterion("uploader >", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderGreaterThanOrEqualTo(String value) {
            addCriterion("uploader >=", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLessThan(String value) {
            addCriterion("uploader <", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLessThanOrEqualTo(String value) {
            addCriterion("uploader <=", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderLike(String value) {
            addCriterion("uploader like", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotLike(String value) {
            addCriterion("uploader not like", value, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderIn(List<String> values) {
            addCriterion("uploader in", values, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotIn(List<String> values) {
            addCriterion("uploader not in", values, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderBetween(String value1, String value2) {
            addCriterion("uploader between", value1, value2, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploaderNotBetween(String value1, String value2) {
            addCriterion("uploader not between", value1, value2, "uploader");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNull() {
            addCriterion("upload_time is null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIsNotNull() {
            addCriterion("upload_time is not null");
            return (Criteria) this;
        }

        public Criteria andUploadTimeEqualTo(Date value) {
            addCriterion("upload_time =", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotEqualTo(Date value) {
            addCriterion("upload_time <>", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThan(Date value) {
            addCriterion("upload_time >", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_time >=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThan(Date value) {
            addCriterion("upload_time <", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeLessThanOrEqualTo(Date value) {
            addCriterion("upload_time <=", value, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeIn(List<Date> values) {
            addCriterion("upload_time in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotIn(List<Date> values) {
            addCriterion("upload_time not in", values, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeBetween(Date value1, Date value2) {
            addCriterion("upload_time between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andUploadTimeNotBetween(Date value1, Date value2) {
            addCriterion("upload_time not between", value1, value2, "uploadTime");
            return (Criteria) this;
        }

        public Criteria andRowStatusIsNull() {
            addCriterion("row_status is null");
            return (Criteria) this;
        }

        public Criteria andRowStatusIsNotNull() {
            addCriterion("row_status is not null");
            return (Criteria) this;
        }

        public Criteria andRowStatusEqualTo(String value) {
            addCriterion("row_status =", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotEqualTo(String value) {
            addCriterion("row_status <>", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusGreaterThan(String value) {
            addCriterion("row_status >", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusGreaterThanOrEqualTo(String value) {
            addCriterion("row_status >=", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLessThan(String value) {
            addCriterion("row_status <", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLessThanOrEqualTo(String value) {
            addCriterion("row_status <=", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusLike(String value) {
            addCriterion("row_status like", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotLike(String value) {
            addCriterion("row_status not like", value, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusIn(List<String> values) {
            addCriterion("row_status in", values, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotIn(List<String> values) {
            addCriterion("row_status not in", values, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusBetween(String value1, String value2) {
            addCriterion("row_status between", value1, value2, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowStatusNotBetween(String value1, String value2) {
            addCriterion("row_status not between", value1, value2, "rowStatus");
            return (Criteria) this;
        }

        public Criteria andRowVersionIsNull() {
            addCriterion("row_version is null");
            return (Criteria) this;
        }

        public Criteria andRowVersionIsNotNull() {
            addCriterion("row_version is not null");
            return (Criteria) this;
        }

        public Criteria andRowVersionEqualTo(Date value) {
            addCriterion("row_version =", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionNotEqualTo(Date value) {
            addCriterion("row_version <>", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionGreaterThan(Date value) {
            addCriterion("row_version >", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionGreaterThanOrEqualTo(Date value) {
            addCriterion("row_version >=", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionLessThan(Date value) {
            addCriterion("row_version <", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionLessThanOrEqualTo(Date value) {
            addCriterion("row_version <=", value, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionIn(List<Date> values) {
            addCriterion("row_version in", values, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionNotIn(List<Date> values) {
            addCriterion("row_version not in", values, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionBetween(Date value1, Date value2) {
            addCriterion("row_version between", value1, value2, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andRowVersionNotBetween(Date value1, Date value2) {
            addCriterion("row_version not between", value1, value2, "rowVersion");
            return (Criteria) this;
        }

        public Criteria andFileInfoUidLikeInsensitive(String value) {
            addCriterion("upper(file_info_uid) like", value.toUpperCase(), "fileInfoUid");
            return (Criteria) this;
        }

        public Criteria andFilePathLikeInsensitive(String value) {
            addCriterion("upper(file_path) like", value.toUpperCase(), "filePath");
            return (Criteria) this;
        }

        public Criteria andFileNameLikeInsensitive(String value) {
            addCriterion("upper(file_name) like", value.toUpperCase(), "fileName");
            return (Criteria) this;
        }

        public Criteria andFileExtentionLikeInsensitive(String value) {
            addCriterion("upper(file_extention) like", value.toUpperCase(), "fileExtention");
            return (Criteria) this;
        }

        public Criteria andUploaderLikeInsensitive(String value) {
            addCriterion("upper(uploader) like", value.toUpperCase(), "uploader");
            return (Criteria) this;
        }

        public Criteria andRowStatusLikeInsensitive(String value) {
            addCriterion("upper(row_status) like", value.toUpperCase(), "rowStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table file_info
     *
     * @mbggenerated do_not_delete_during_merge Wed Nov 08 20:53:33 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table file_info
     *
     * @mbggenerated Wed Nov 08 20:53:33 CST 2017
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}