package org.example.dao;

import org.example.domain.Company;

import java.util.List;

/**
 * @Author: WangTao
 * @Date: 2023-02-01 14:02
 * @Version: 1.0
 * @Desc:
 */
public interface CompanyDao {
    /**
     * 新增数据
     *
     * @param company:新增数据
     */
    void save(Company company);

    /**
     * 更新数据
     *
     * @param company:修改数据
     */
    void update(Company company);

    /**
     * 删除数据
     *
     * @param id：删除数据id
     */
    void delete(String id);

    /**
     * 根据ID查询
     *
     * @param id：查询数据id
     * @return： 查询结果
     */
    Company findById(String id);

    /**
     * 查询所有
     *
     * @return: 查询结果集
     */
    List<Company> findAll();
}
