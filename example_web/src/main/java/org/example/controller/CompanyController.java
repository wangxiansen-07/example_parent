package org.example.controller;

import org.example.domain.Company;
import org.example.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: WangTao
 * @Date: 2023-02-01 15:03
 * @Version: 1.0
 * @Desc:
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/save", name = "添加数据")
    public void save(@RequestBody Company company) {
        logger.info("save data = {}", company);
        companyService.save(company);
    }

    @RequestMapping(value = "/update", name = "修改数据")
    public void update(@RequestBody Company company) {
        logger.info("update data = {}", company);
        companyService.update(company);
    }

    @RequestMapping(value = "/delete", name = "删除数据")
    public void delete(String id) {
        logger.info("delete id = {}", id);
        companyService.delete(id);
    }

    @RequestMapping(value = "/findById", name = "根据id查询")
    public Company findById(String id) {
        logger.info("findById:{}", id);
        Company company = companyService.findById(id);
        logger.info("findById result:{}", company);
        return company;
    }

    @RequestMapping(value = "/findAll", name = "所有查询")
    public List<Company> findAll() {
        logger.info("findAll：");
        List<Company> companies = companyService.findAll();
        logger.info("findAll result:{}", companies);
        return companies;
    }
}
