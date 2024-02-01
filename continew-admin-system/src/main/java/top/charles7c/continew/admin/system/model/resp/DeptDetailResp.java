/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.charles7c.continew.admin.system.model.resp;

import cn.crane4j.annotation.AssembleMethod;
import cn.crane4j.annotation.ContainerMethod;
import cn.crane4j.annotation.Mapping;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import top.charles7c.continew.admin.common.enums.DisEnableStatusEnum;
import top.charles7c.continew.admin.system.service.DeptService;
import top.charles7c.continew.starter.extension.crud.model.resp.BaseDetailResp;
import top.charles7c.continew.starter.extension.crud.converter.ExcelBaseEnumConverter;

import java.io.Serial;

/**
 * 部门详情信息
 *
 * @author Charles7c
 * @since 2023/2/1 22:19
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "部门详情信息")
public class DeptDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 名称
     */
    @Schema(description = "名称", example = "测试部")
    @ExcelProperty(value = "名称")
    private String name;

    /**
     * 上级部门 ID
     */
    @Schema(description = "上级部门 ID", example = "2")
    @AssembleMethod(targetType = DeptService.class, method = @ContainerMethod(bindMethod = "get", resultType = DeptDetailResp.class), props = @Mapping(src = "name", ref = "parentName"))
    private Long parentId;

    /**
     * 上级部门
     */
    @Schema(description = "上级部门", example = "天津总部")
    @ExcelProperty(value = "上级部门")
    private String parentName;

    /**
     * 排序
     */
    @Schema(description = "排序", example = "1")
    private Integer sort;

    /**
     * 状态
     */
    @Schema(description = "状态（1：启用；2：禁用）", type = "Integer", allowableValues = {"1", "2"}, example = "1")
    @ExcelProperty(value = "状态", converter = ExcelBaseEnumConverter.class)
    private DisEnableStatusEnum status;

    /**
     * 是否为系统内置数据
     */
    @Schema(description = "是否为系统内置数据", example = "false")
    @ExcelProperty(value = "系统内置")
    private Boolean isSystem;

    /**
     * 描述
     */
    @Schema(description = "描述", example = "测试部描述信息")
    @ExcelProperty(value = "描述")
    private String description;

    @Override
    public Boolean getDisabled() {
        return this.getIsSystem();
    }
}
