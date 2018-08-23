/*
 * @(#)StarterEdasApplication.java      2018/8/14
 *
 * 百得利集团拥有完全的版权
 * 使用者必须经过许可
 */
package com.micro.demo.edas;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.edas.model.v20170801.ListDeployGroupRequest;
import com.aliyuncs.edas.model.v20170801.ListDeployGroupResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 功能：Edas服务启动类
 *
 * @author twfx7
 * @since JDK 1.8
 */
public class StarterEdasApplication {
    public static void main(String[] args) throws ClientException {
        /**
         *Open API 的接入点，具体查看 EDAS 支持地域列表以及购买机器地域填写
         */
        String regionId = "XXXXX";
        /**
         *鉴权使用的 AccessKeyId，由阿里云官网控制台获取
         */
        String accessKeyId = "XXXXXXXXXXXXXXXXX";
        /**
         *鉴权使用的 AccessKeySecret，由阿里云官网控制台获取
         */
        String accessKeySecret = "XXXXXXXXXXXXXXXXX";
        /**
         * 通过 Open API 访问的云产品名称，此处设置为 Edas 即可
         */
        String productName ="Edas";
        /**
         *对应 endPoint 接入点的接入点域名,具体参考 EDAS 支持地域列表里面的 domain
         */
        String domain ="edas.XXXXX.aliyuncs.com";
        // 构建 OpenApi 客户端
        DefaultProfile.addEndpoint(regionId,regionId,productName,domain);
        DefaultProfile defaultProfile = DefaultProfile.getProfile(regionId, accessKeyId, accessKeySecret);
        DefaultAcsClient defaultAcsClient = new DefaultAcsClient(defaultProfile);
        defaultAcsClient.setAutoRetry(false);

        // 构建应用部署分组列表接口请求具体入参参考接口说明
        String appId = "xxxxxxxxx";
        ListDeployGroupRequest request = new ListDeployGroupRequest();
        // 具体入参参考具体接口说明
        request.setAppId(appId);
        ListDeployGroupResponse response = defaultAcsClient.getAcsResponse(request);
        // 结果解析(code=200表示调用成功,其他均为失败调用具体参考列表)
        if (response.getCode() == 200) {
            // 解析具体返回结果(参考具体接口返回值)
            List<ListDeployGroupResponse.DeployGroup> deployGroups = response.getDeployGroupList();
            if (CollectionUtils.isNotEmpty(deployGroups)) {
                for (ListDeployGroupResponse.DeployGroup deployGroup : deployGroups) {
                    System.out.println(deployGroup.getGroupName());
                    System.out.println(deployGroup.getGroupId());
                }
            }
        } else {
            // 打印错误原因
            System.out.println(response.getMessage());
        }
    }
}
