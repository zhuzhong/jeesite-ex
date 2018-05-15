/**
 * 
 */
package com.thinkgem.jeesite.modules.sys.cas.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkgem.jeesite.modules.sys.dao.MenuDao;
import com.thinkgem.jeesite.modules.sys.entity.Menu;
import com.thinkgem.jeesite.modules.sys.entity.Role;
import com.thinkgem.jeesite.modules.sys.entity.User;
import com.thinkgem.jeesite.modules.sys.service.impl.SystemService;
import com.thinkgem.jeesite.modules.sys.utils.UserUtils;
import com.z.jeesite.sys.api.CasUserService;
import com.z.jeesite.sys.api.dto.CasUser;

/**
 * @author zhuzhong
 *
 */
@Service
public class CasUserServiceImpl implements CasUserService {

    private static final Logger logger = LoggerFactory.getLogger(CasUserServiceImpl.class);
    @Autowired
    private SystemService systemService;

    @Autowired
    private MenuDao menuDao;

    @Override
    public CasUser getUserByLoginName(String loginName) {
        User user = systemService.getUserByLoginName(loginName);
        if (user == null) {
            return null;
        }
        CasUser casUser = new CasUser();
        casUser.setId(user.getId());
        casUser.setLoginFlag(user.getLoginFlag());
        casUser.setLoginName(user.getLoginName());
        casUser.setName(user.getName());

        List<Menu> menuList = null;
        User currentUser = UserUtils.getUser();
        if (currentUser == null || currentUser.getId() == null || !currentUser.getId().equals(user.getId())) {
            logger.info("无法直接获取当前用户信息，loginname={}", loginName);
            if (user.isAdmin()) {
                menuList = menuDao.findAllList(new Menu());
            } else {
                Menu m = new Menu();
                m.setUserId(user.getId());
                menuList = menuDao.findByUserId(m);
            }

        } else {
            logger.info("可以获取到当前用户信息...,loginname={}", loginName);
            menuList = UserUtils.getMenuList();
        }

        if (menuList != null && menuList.size() > 0) {
            for (Menu menu : menuList) {
                casUser.addPermission(menu.getPermission());
            }
        }
        if (user.getRoleList() != null) {
            for (Role role : user.getRoleList()) {
                casUser.addRoleEnName(role.getEnname());
            }
        }

        return casUser;
    }

}