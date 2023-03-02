/*
 Navicat Premium Data Transfer

 Source Server         : crm
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : crm

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 09/06/2020 21:49:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_add_friend_group
-- ----------------------------
DROP TABLE IF EXISTS `c_add_friend_group`;
CREATE TABLE `c_add_friend_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '添加好友id',
  `af_user_id` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加者id',
  `af_to_user_id` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '被添加者id',
  `af_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加备注',
  `af_friend_or_group` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加是朋友还是群组',
  `af_group_id` int(11) NULL DEFAULT NULL COMMENT '添加到哪一个分组',
  `af_is_yes` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '添加成功了没有',
  `af_create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_add_friend_group
-- ----------------------------
INSERT INTO `c_add_friend_group` VALUES (8, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '你好！', 'friend', 1, '1', '2020-06-01 16:36:25');
INSERT INTO `c_add_friend_group` VALUES (10, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '拟稿', 'friend', 2, '1', '2020-06-01 17:44:08');
INSERT INTO `c_add_friend_group` VALUES (11, '0626ac64-9ce7-4b99-a114-715dd05050ca', '1', '你好', 'friend', 4, '1', '2020-06-01 18:04:14');
INSERT INTO `c_add_friend_group` VALUES (12, 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '1', '你好。', 'friend', 3, '1', '2020-06-01 18:47:59');
INSERT INTO `c_add_friend_group` VALUES (13, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '1', '我爱你', 'friend', 1, '1', '2020-06-01 19:06:26');
INSERT INTO `c_add_friend_group` VALUES (14, 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '1', '你哈', 'friend', 3, '1', '2020-06-02 09:27:12');
INSERT INTO `c_add_friend_group` VALUES (15, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '你是姚林辉吗？', 'friend', 1, '1', '2020-06-04 16:24:52');
INSERT INTO `c_add_friend_group` VALUES (16, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '你是姚林辉吗？', 'friend', 1, '1', '2020-06-04 16:31:27');
INSERT INTO `c_add_friend_group` VALUES (17, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '姚林辉，你好呀！', 'friend', 1, '1', '2020-06-04 16:49:27');
INSERT INTO `c_add_friend_group` VALUES (18, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '你是姚林辉吗？我和喜欢你！', 'friend', 1, '1', '2020-06-04 16:54:26');
INSERT INTO `c_add_friend_group` VALUES (19, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '你好！', 'friend', 1, '1', '2020-06-04 17:49:11');
INSERT INTO `c_add_friend_group` VALUES (20, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '你是姚林辉吗？', 'friend', 1, '1', '2020-06-04 19:12:05');
INSERT INTO `c_add_friend_group` VALUES (21, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '你是姚林辉吗？', 'friend', 1, '1', '2020-06-04 19:21:00');
INSERT INTO `c_add_friend_group` VALUES (22, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '你好！', 'friend', 1, '1', '2020-06-04 19:31:38');
INSERT INTO `c_add_friend_group` VALUES (23, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '你是姚林辉吗？', 'friend', 1, '1', '2020-06-05 09:31:56');

-- ----------------------------
-- Table structure for c_dynamic_message
-- ----------------------------
DROP TABLE IF EXISTS `c_dynamic_message`;
CREATE TABLE `c_dynamic_message`  (
  `dm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动态信息的编号id',
  `user_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推动信息的员工编号(推送人：网络咨询师)',
  `user_id2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '接收信息的员工编号(被推送人：咨询师）',
  `student_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推送目标关联Studnet表的sid',
  `s_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名(哪个学生的信息)',
  `dm_read` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否已读（判断）',
  `dm_create_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `dm_message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推送信息',
  `standby1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字符串备用字段',
  `standby2` int(11) NULL DEFAULT NULL COMMENT '整数备用字段',
  PRIMARY KEY (`dm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_dynamic_message
-- ----------------------------
INSERT INTO `c_dynamic_message` VALUES (3, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '932a7cc5-37b6-47a9-af78-459a5c7cf921', '小飞', '已读', '2020-05-24 09:58:09', '01.道可道，非常道。名可名，非常名。无，名天地之始。有，名万物之母。故常无，欲以观其妙。常有，欲以观其徼。此两者同出而异名，同谓之玄。玄之又玄，众妙之门。', NULL, NULL);
INSERT INTO `c_dynamic_message` VALUES (4, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '932a7cc5-37b6-47a9-af78-459a5c7cf921', '小飞', '已读', '2020-05-24 09:58:53', '02.天下皆知美之为美，斯恶矣；皆知善之为善，斯不善已。故有无相生，难易相成，长短相形，高下相倾，音声相和，前后相随。是以圣人处无为之事，行不言之教。万物作焉而不辞。生而不有，为而不恃，功成而弗居。夫唯弗居，是以不去。', NULL, NULL);
INSERT INTO `c_dynamic_message` VALUES (5, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '017ba98f-92a3-40d2-abff-7bfb1cbfcae5', '李志', '已读', '2020-05-24 14:13:18', '03.不尚贤， 使民不争。不贵难得之货，使民不为盗。不见可欲，使民心不乱。是以圣人之治，虚其心，实其腹，弱其志，强其骨；常使民无知、无欲，使夫智者不敢为也。为无为，则无不治。', NULL, NULL);
INSERT INTO `c_dynamic_message` VALUES (6, '580a5d29-94f3-4511-b17b-c1faf5902feb', '580a5d29-94f3-4511-b17b-c1faf5902feb', '017ba98f-92a3-40d2-abff-7bfb1cbfcae5', '李志', '未读', '2020-05-28 08:40:39', '测试', NULL, NULL);
INSERT INTO `c_dynamic_message` VALUES (7, '580a5d29-94f3-4511-b17b-c1faf5902feb', '580a5d29-94f3-4511-b17b-c1faf5902feb', '017ba98f-92a3-40d2-abff-7bfb1cbfcae5', '李志', '已读', '2020-05-28 09:32:16', '你是', NULL, NULL);

-- ----------------------------
-- Table structure for c_emp
-- ----------------------------
DROP TABLE IF EXISTS `c_emp`;
CREATE TABLE `c_emp`  (
  `e_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_to_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_status` int(11) NULL DEFAULT NULL,
  `e_sign` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_is_login` int(11) NULL DEFAULT NULL,
  `e_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_mine` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_time_stamp` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `e_history_time` datetime(0) NULL DEFAULT NULL,
  `e_is_read` int(11) NULL DEFAULT 0 COMMENT '是否已读 0为未读 1位已读'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_emp
-- ----------------------------
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '你好。', 'friend', '0', '1000011', '2020-05-29 10:50:40', 1);
INSERT INTO `c_emp` VALUES ('0626ac64-9ce7-4b99-a114-715dd05050ca', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '姚林辉', 1, '你好', '../../../images/f37cec6e-0a76-407e-9228-749580041930.jpg', 1, '我不好。', 'friend', '0', '2213131', '2020-05-29 10:51:22', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '我爱你。', 'friend', '0', '1223442', '2020-05-29 11:09:16', 1);
INSERT INTO `c_emp` VALUES ('0626ac64-9ce7-4b99-a114-715dd05050ca', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '姚林辉', 1, '你好', '../../../images/f37cec6e-0a76-407e-9228-749580041930.jpg', 1, '我不爱你。', 'friend', '0', '1590751197929', '2020-05-29 11:19:58', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '你好。', 'friend', '0', '1590752551428', '2020-05-29 11:42:31', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '你好，你好，你好。', 'friend', '0', '1590752671306', '2020-05-29 11:44:31', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '你不好', 'friend', '0', '1590752675662', '2020-05-29 11:44:36', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '你不好', 'friend', '0', '1590752678818', '2020-05-29 11:44:39', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '你不好', 'friend', '0', '1590752681790', '2020-05-29 11:44:42', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '你好。', 'friend', '0', '1590850532144', '2020-05-30 14:55:32', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '韦', 1, '你好', '../../../images/3027e355-9983-4b8a-adf0-0d10272fac12.jpg', 1, '你好。', 'friend', '0', '1590938787710', '2020-05-31 15:26:28', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '韦', 1, '你好', '../../../images/c6d346db-726f-4957-9ccb-a99e0dc51e0f.jpg', 1, '你还', 'friend', '0', '1591060803254', '2020-06-02 01:20:03', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '21986948-1adb-476a-a505-1df5baa88788', '韦', 1, '你好', '../../../images/c6d346db-726f-4957-9ccb-a99e0dc51e0f.jpg', 1, '你好', 'friend', '0', '1591060812983', '2020-06-02 01:20:13', 0);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '韦', 1, '你好', '../../../images/c6d346db-726f-4957-9ccb-a99e0dc51e0f.jpg', 1, '你好', 'friend', '0', '1591060840529', '2020-06-02 01:20:41', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '韦', 1, '你好', '../../../images/c6d346db-726f-4957-9ccb-a99e0dc51e0f.jpg', 1, '网不好', 'friend', '0', '1591060903442', '2020-06-02 01:21:43', 1);
INSERT INTO `c_emp` VALUES ('afd330d5-645e-4dd9-8c28-ff0a7063cac2', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '李志', 1, '你好', '../../../images/ebc5b956-017e-438d-85bc-0405a158a27b.jpg', 1, '你好’', 'friend', '0', '1591061190908', '2020-06-02 01:26:31', 1);
INSERT INTO `c_emp` VALUES ('1', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '柯本', 1, '你好', '../../../images/6874d924-9589-46d8-80e8-f5c416886818.jpg', 1, 'face[鼓掌] ', 'friend', '0', '1591061351878', '2020-06-02 01:29:12', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, '你好呀！face[嘻嘻] ', 'friend', '0', '1591254521741', '2020-06-04 07:08:42', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, '你好呀！', 'friend', '0', '1591254751826', '2020-06-04 07:12:32', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, '我看过你演的霸王别姬！face[哈哈] ', 'friend', '0', '1591254791554', '2020-06-04 07:13:12', 1);
INSERT INTO `c_emp` VALUES ('580a5d29-94f3-4511-b17b-c1faf5902feb', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '张国荣', 1, '你好', '../../../images/62a6d409-ab7d-45c3-a982-b36cd9e9d1f1.jpg', 1, '谢谢！', 'friend', '0', '1591254806952', '2020-06-04 07:13:27', 1);
INSERT INTO `c_emp` VALUES ('afd330d5-645e-4dd9-8c28-ff0a7063cac2', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '李志', 1, '你好', '../../../images/6973475d-d0a3-4561-917c-a3a65eef9827.jpg', 1, '你好！face[哈哈] ', 'friend', '0', '1591254884491', '2020-06-04 07:14:44', 1);
INSERT INTO `c_emp` VALUES ('afd330d5-645e-4dd9-8c28-ff0a7063cac2', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '李志', 1, '你好', '../../../images/6973475d-d0a3-4561-917c-a3a65eef9827.jpg', 1, '为什么是离线？', 'friend', '0', '1591254992491', '2020-06-04 07:16:32', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, '这个是BUG！', 'friend', '0', '1591255007633', '2020-06-04 07:16:48', 1);
INSERT INTO `c_emp` VALUES ('afd330d5-645e-4dd9-8c28-ff0a7063cac2', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '李志', 1, '你好', '../../../images/6973475d-d0a3-4561-917c-a3a65eef9827.jpg', 1, '我现在马上去修复！face[黑线] ', 'friend', '0', '1591255027927', '2020-06-04 07:17:08', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, '好的，非常期待你完成！', 'friend', '0', '1591255052784', '2020-06-04 07:17:33', 1);
INSERT INTO `c_emp` VALUES ('afd330d5-645e-4dd9-8c28-ff0a7063cac2', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '李志', 1, '你好', '../../../images/6973475d-d0a3-4561-917c-a3a65eef9827.jpg', 1, '谢谢！', 'friend', '0', '1591255069029', '2020-06-04 07:17:49', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, '你好呀！', 'friend', '0', '1591269044541', '2020-06-04 11:10:45', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, '你好！', 'friend', '0', '1591269335162', '2020-06-04 11:15:35', 1);
INSERT INTO `c_emp` VALUES ('0626ac64-9ce7-4b99-a114-715dd05050ca', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '姚林辉', 1, '你好', '../../../images/16226381-b09a-4f64-9f4f-a1ec9c7cbc4e.jpg', 1, '你也好呀！', 'friend', '0', '1591269377341', '2020-06-04 11:16:17', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, '你好？', 'friend', '0', '1591320966472', '2020-06-05 01:36:06', 1);
INSERT INTO `c_emp` VALUES ('0626ac64-9ce7-4b99-a114-715dd05050ca', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '姚林辉', 1, '你好', '../../../images/16226381-b09a-4f64-9f4f-a1ec9c7cbc4e.jpg', 1, '你好。', 'friend', '0', '1591320982056', '2020-06-05 01:36:22', 1);
INSERT INTO `c_emp` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '0626ac64-9ce7-4b99-a114-715dd05050ca', '许巍', 1, '你好', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', 1, 'face[嘻嘻] ', 'friend', '0', '1591320996078', '2020-06-05 01:36:36', 1);

-- ----------------------------
-- Table structure for c_follows
-- ----------------------------
DROP TABLE IF EXISTS `c_follows`;
CREATE TABLE `c_follows`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '回访记录编号',
  `student_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '跟踪学生',
  `s_name` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '跟踪学生姓名',
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'UUID 访问者id',
  `f_time` datetime(0) NULL DEFAULT NULL COMMENT '跟踪时间',
  `f_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '沟通内容',
  `f_next_time` datetime(0) NULL DEFAULT NULL COMMENT '下次跟踪时间',
  `f_feedback` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '跟踪反馈信息',
  `f_type` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '\'老客户\'  老客户、新客户、休眠客户',
  `f_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信、电话等',
  `f_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '譬如：考虑中、准备报名',
  `f_show` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否显示该条信息(回收站)true false',
  `s_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '整数备用字段',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_follows
-- ----------------------------
INSERT INTO `c_follows` VALUES (3, '1d74cfc6-2ef4-4a78-8eac-0f455ae00ca8', '小明', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '2020-05-17 16:00:00', '1', '2020-05-17 16:00:00', '1123', '新客户', '电话', '考虑中', 'true', '13813814438');
INSERT INTO `c_follows` VALUES (4, '3', '小明', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '2020-05-19 16:00:00', '13', '2020-05-19 16:00:00', '123', '新客户', '微信', '无意向', 'true', '13813814431');
INSERT INTO `c_follows` VALUES (12, '1d74cfc6-2ef4-4a78-8eac-0f455ae00ca8', '小明', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '2020-05-21 16:00:00', '12', '2020-05-29 16:00:00', '12', '新客户', '电话', '准备中', 'true', '13813814438');
INSERT INTO `c_follows` VALUES (14, '017ba98f-92a3-40d2-abff-7bfb1cbfcae5', '李志', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '2020-05-21 16:00:00', '测试', '2020-05-21 16:00:00', '测试', '新客户', 'QQ', '考虑中', 'true', '15938096023');
INSERT INTO `c_follows` VALUES (16, '017ba98f-92a3-40d2-abff-7bfb1cbfcae5', '李志', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '2020-06-05 16:00:00', '开组', '2020-06-05 16:00:00', '李志', '老客户', '微信', '考虑中', 'true', '15938096023');
INSERT INTO `c_follows` VALUES (20, '440c1574-a497-46ba-9890-c1f4a6da49a5', '萧伯纳', '580a5d29-94f3-4511-b17b-c1faf5902feb', '2020-06-17 16:00:00', '测试', '2020-06-08 16:00:00', '测试', '新客户', '微信', '考虑中', 'true', '13000119999');
INSERT INTO `c_follows` VALUES (21, '440c1574-a497-46ba-9890-c1f4a6da49a5', '萧伯纳', '580a5d29-94f3-4511-b17b-c1faf5902feb', '2020-06-08 16:00:00', '测试', '2020-06-08 16:00:00', '测试', '新客户', '电话', '考虑中', 'true', '13000119999');
INSERT INTO `c_follows` VALUES (22, 'bbc5c235-2db4-47a1-bd43-84acd41c4eb0', '罗曼·罗兰', '580a5d29-94f3-4511-b17b-c1faf5902feb', '2020-06-08 16:00:00', '测试', '2020-06-08 16:00:00', '测试', '新客户', 'QQ', '准备中', 'true', '13438096021');
INSERT INTO `c_follows` VALUES (23, 'bbc5c235-2db4-47a1-bd43-84acd41c4eb0', '罗曼·罗兰', '580a5d29-94f3-4511-b17b-c1faf5902feb', '2020-06-08 16:00:00', '测试', '2020-06-08 16:00:00', '测试', '新客户', '微信', '考虑中', 'true', '13438096021');

-- ----------------------------
-- Table structure for c_friend
-- ----------------------------
DROP TABLE IF EXISTS `c_friend`;
CREATE TABLE `c_friend`  (
  `f_id` int(11) NOT NULL,
  `f_group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `f_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_friend
-- ----------------------------
INSERT INTO `c_friend` VALUES (1, '朋友', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a');
INSERT INTO `c_friend` VALUES (2, '家人', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a');
INSERT INTO `c_friend` VALUES (3, '朋友', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2');
INSERT INTO `c_friend` VALUES (4, '朋友', '0626ac64-9ce7-4b99-a114-715dd05050ca');
INSERT INTO `c_friend` VALUES (5, '朋友', '1');

-- ----------------------------
-- Table structure for c_friend_user
-- ----------------------------
DROP TABLE IF EXISTS `c_friend_user`;
CREATE TABLE `c_friend_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分组用户中间表',
  `fz_id` int(11) NULL DEFAULT NULL COMMENT '分组id',
  `user_id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_friend_user
-- ----------------------------
INSERT INTO `c_friend_user` VALUES (1, 1, '580a5d29-94f3-4511-b17b-c1faf5902feb');
INSERT INTO `c_friend_user` VALUES (2, 1, 'afd330d5-645e-4dd9-8c28-ff0a7063cac2');
INSERT INTO `c_friend_user` VALUES (3, 2, '21986948-1adb-476a-a505-1df5baa88788');
INSERT INTO `c_friend_user` VALUES (4, 3, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a');
INSERT INTO `c_friend_user` VALUES (12, 4, '21986948-1adb-476a-a505-1df5baa88788');
INSERT INTO `c_friend_user` VALUES (19, 5, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a');
INSERT INTO `c_friend_user` VALUES (28, 5, 'afd330d5-645e-4dd9-8c28-ff0a7063cac2');
INSERT INTO `c_friend_user` VALUES (48, 4, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a');
INSERT INTO `c_friend_user` VALUES (49, 1, '0626ac64-9ce7-4b99-a114-715dd05050ca');

-- ----------------------------
-- Table structure for c_group
-- ----------------------------
DROP TABLE IF EXISTS `c_group`;
CREATE TABLE `c_group`  (
  `g_id` int(11) NOT NULL,
  `g_group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `g_avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `g_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`g_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_group
-- ----------------------------
INSERT INTO `c_group` VALUES (1, '坚果手机友', 'yaolinhui', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a');
INSERT INTO `c_group` VALUES (2, '电脑爱好者', '电脑爱好者', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a');

-- ----------------------------
-- Table structure for c_group_user
-- ----------------------------
DROP TABLE IF EXISTS `c_group_user`;
CREATE TABLE `c_group_user`  (
  `gu_id` int(11) NOT NULL COMMENT '群与用户中间表编号',
  `gu_group_id` int(11) NULL DEFAULT NULL COMMENT '群编号',
  `gu_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`gu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_group_user
-- ----------------------------
INSERT INTO `c_group_user` VALUES (1, 1, 'afd330d5-645e-4dd9-8c28-ff0a7063cac2');
INSERT INTO `c_group_user` VALUES (2, 1, '580a5d29-94f3-4511-b17b-c1faf5902feb');
INSERT INTO `c_group_user` VALUES (3, 1, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a');

-- ----------------------------
-- Table structure for c_messages
-- ----------------------------
DROP TABLE IF EXISTS `c_messages`;
CREATE TABLE `c_messages`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID自增主键',
  `user_id` varchar(200) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT 'UUID (发送者就是用户)',
  `uc_name` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '发送者姓名（用户姓名）',
  `student_id` int(11) NULL DEFAULT NULL COMMENT '接收者ID（学生ID自增）',
  `s_name` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '接收者姓名（学生姓名可以一样）',
  `m_content` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '聊天室内两个人的对话',
  `m_create_time` datetime(0) NULL DEFAULT NULL COMMENT '发送时间',
  `m_read` varchar(10) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '对方是否已读信息（0，已读  1，未读）',
  `standby1` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '字符串备用字段',
  `standby2` int(11) NULL DEFAULT NULL COMMENT '整数备用字段',
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_messages
-- ----------------------------

-- ----------------------------
-- Table structure for c_modules
-- ----------------------------
DROP TABLE IF EXISTS `c_modules`;
CREATE TABLE `c_modules`  (
  `module_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模块编号',
  `m_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模块名称',
  `m_parent_id` int(11) NULL DEFAULT NULL COMMENT '父模块编号顶级父模块为0',
  `m_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块路径',
  `m_weight` int(11) NULL DEFAULT NULL COMMENT '权重（数字越大，越优先显示）',
  `standby1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预留字符串字段',
  `standby2` int(11) NULL DEFAULT NULL COMMENT '预留整数字段',
  PRIMARY KEY (`module_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_modules
-- ----------------------------
INSERT INTO `c_modules` VALUES (1, '系统管理', 0, '#', 5, NULL, NULL);
INSERT INTO `c_modules` VALUES (2, '客户管理', 0, '#', 5, NULL, NULL);
INSERT INTO `c_modules` VALUES (3, '用户管理', 1, 'system/user/user.html', 1, NULL, NULL);
INSERT INTO `c_modules` VALUES (4, '角色管理', 1, 'system/role/role.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (5, '模块管理', 1, 'system/module/module.html', 2, NULL, NULL);
INSERT INTO `c_modules` VALUES (6, '权限管理', 1, 'system/permission/permission.html', 1, NULL, NULL);
INSERT INTO `c_modules` VALUES (7, '网络学生管理', 2, 'client/student/student.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (8, '跟踪访问管理', 2, 'client/follow/follow.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (44, '考勤管理', 2, 'system/user/userChecks.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (45, '图表显示', 2, 'tubiao', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (48, '学生信息回收站', 2, 'client/recycleBin/studentRecycleBin.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (49, '跟踪信息回收站', 2, 'client/follow/follow-recycle.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (50, '未分配学生', 2, 'client/student/unallotStudent.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (51, '分量管理', 2, 'client/student/allotOperation.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (54, '字典管理', 2, 'admin/client/follow/follow-recycle.html', 100, NULL, NULL);
INSERT INTO `c_modules` VALUES (55, '我的学生管理', 2, 'client/student/myStudent.html', 100, NULL, NULL);

-- ----------------------------
-- Table structure for c_permission
-- ----------------------------
DROP TABLE IF EXISTS `c_permission`;
CREATE TABLE `c_permission`  (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限管理编号',
  `p_parent` int(11) NULL DEFAULT NULL COMMENT '对应父权限ID',
  `p_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限值',
  `p_module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限对应模块名称',
  `p_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `p_update_time` datetime(0) NULL DEFAULT NULL COMMENT '数据更新时间',
  `standby2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '整数备用字段',
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_permission
-- ----------------------------
INSERT INTO `c_permission` VALUES (1, 0, 'system/user/user.html', '用户管理', '用户管理', '2020-06-04 08:31:04', '1');
INSERT INTO `c_permission` VALUES (2, 1, 'user:add', '用户添加', '用户添加', '2020-05-12 08:48:39', '1');
INSERT INTO `c_permission` VALUES (3, 1, 'user:delete', '用户删除', '用户删除', '2020-05-12 08:48:39', '1');
INSERT INTO `c_permission` VALUES (4, 1, 'user:deleteall', '用户批量删除', '用户批量删除', '2020-05-12 14:33:33', '1');
INSERT INTO `c_permission` VALUES (5, 1, 'user:setRole', '用户设置角色', '用户设置角色', '2020-05-12 14:34:19', '1');
INSERT INTO `c_permission` VALUES (6, 1, 'user:restPassword', '用户重设密码', '用户重设密码', '2020-05-12 14:35:10', '1');
INSERT INTO `c_permission` VALUES (7, 1, 'user:dao', '用户导入', '用户导入', '2020-05-12 14:35:33', '1');
INSERT INTO `c_permission` VALUES (8, 1, 'user:chu', '用户导出', '用户导出', '2020-05-13 13:27:33', '1');
INSERT INTO `c_permission` VALUES (18, 0, 'system/module/module.html', '模块管理', '模块管理', '2020-06-04 08:32:29', NULL);
INSERT INTO `c_permission` VALUES (19, 0, 'system/role/role.html', '角色管理', '角色管理', '2020-06-04 08:31:34', NULL);
INSERT INTO `c_permission` VALUES (20, 18, 'module:add', '模块添加', '模块添加', '2020-05-17 09:16:35', NULL);
INSERT INTO `c_permission` VALUES (21, 18, 'module:delete', '模块删除', '模块删除', '2020-05-17 09:17:00', NULL);
INSERT INTO `c_permission` VALUES (22, 18, 'module:pliangdelete', '模块批量删除', '模块批量删除', '2020-05-17 09:17:22', NULL);
INSERT INTO `c_permission` VALUES (23, 18, 'module:update', '模块编辑', '模块编辑', '2020-05-17 11:59:55', NULL);
INSERT INTO `c_permission` VALUES (24, 19, 'role:add', '角色添加', '角色添加', '2020-05-17 09:18:32', NULL);
INSERT INTO `c_permission` VALUES (25, 19, 'role:delete', '角色删除', '角色删除', '2020-05-17 09:18:46', NULL);
INSERT INTO `c_permission` VALUES (26, 19, 'role:piliangdelete', '角色批量删除', '角色批量删除', '2020-05-17 09:19:00', NULL);
INSERT INTO `c_permission` VALUES (27, 19, 'role:setpermission', '角色设置权限', '角色设置权限', '2020-05-17 09:19:23', NULL);
INSERT INTO `c_permission` VALUES (28, 19, 'role:setmodule', '角色设置模块', '角色设置模块', '2020-05-17 09:19:39', NULL);
INSERT INTO `c_permission` VALUES (29, 19, 'role:update', '角色编辑', '角色编辑', '2020-05-17 09:20:23', NULL);
INSERT INTO `c_permission` VALUES (30, 0, 'system/permission/permission.html', '权限管理', '权限管理', '2020-06-04 08:32:04', NULL);
INSERT INTO `c_permission` VALUES (31, 30, 'permission:add', '权限添加', '权限添加', '2020-05-17 09:25:34', NULL);
INSERT INTO `c_permission` VALUES (32, 30, 'permission:delete', '权限删除', '权限删除', '2020-05-17 09:25:54', NULL);
INSERT INTO `c_permission` VALUES (33, 30, 'permission:piliangdelete', '权限批量删除', '权限批量删除', '2020-05-17 09:26:20', NULL);
INSERT INTO `c_permission` VALUES (34, 30, 'permission:update', '权限编辑', '权限编辑', '2020-05-17 09:26:41', NULL);
INSERT INTO `c_permission` VALUES (35, 1, 'user:update', '用户编辑', '用户编辑', '2020-05-17 11:36:54', NULL);
INSERT INTO `c_permission` VALUES (39, 0, 'client/recycleBin/studentRecycleBin.html', '学生信息回收站', '学生信息回收站', '2020-06-05 15:10:10', NULL);
INSERT INTO `c_permission` VALUES (40, 0, 'admin/client/follow/follow-recycle.html', '跟踪信息回收站', '跟踪信息回收站', '2020-05-23 07:42:18', NULL);
INSERT INTO `c_permission` VALUES (41, 0, 'client/student/unallotStudent.html', '未分配学生', '未分配学生', '2020-05-28 08:59:18', NULL);
INSERT INTO `c_permission` VALUES (42, 0, 'client/student/allotOperation.html', '分量管理', '分量管理', '2020-05-28 08:59:42', NULL);
INSERT INTO `c_permission` VALUES (45, 41, 'unallocated:batchAllocate', '未分配批量分配咨询师', '未分配批量分配咨询师', '2020-06-05 15:54:17', NULL);
INSERT INTO `c_permission` VALUES (46, 0, 'admin/client/follow/follow-recycle.html', '字典管理', '字典管理', '2020-06-03 21:33:47', NULL);
INSERT INTO `c_permission` VALUES (47, 0, 'client/student/student.html', '网络学生管理', '网络学生管理', '2020-06-04 08:29:06', NULL);
INSERT INTO `c_permission` VALUES (48, 0, 'client/follow/follow.html', '跟踪访问管理', '跟踪访问管理', '2020-06-04 08:29:48', NULL);
INSERT INTO `c_permission` VALUES (49, 0, 'tubiao', '图表显示', '图表显示', '2020-06-04 08:26:08', NULL);
INSERT INTO `c_permission` VALUES (51, 0, 'system/user/userChecks.html', '考勤管理', '考勤管理', '2020-06-04 08:30:36', NULL);
INSERT INTO `c_permission` VALUES (52, 47, 'student:add', '网络学生添加', '网络学生添加', '2020-06-04 15:21:28', NULL);
INSERT INTO `c_permission` VALUES (53, 47, 'student:deleteRecycle', '网络学生回收站', '网络学生回收站', '2020-06-04 15:22:58', NULL);
INSERT INTO `c_permission` VALUES (54, 47, 'student:show', '网络学生查看', '网络学生查看', '2020-06-04 15:23:24', NULL);
INSERT INTO `c_permission` VALUES (55, 47, 'student:delete', '网络学生删除', '网络学生删除', '2020-06-04 15:23:37', NULL);
INSERT INTO `c_permission` VALUES (56, 47, 'student:update', '网络学生编辑', '网络学生编辑', '2020-06-04 15:23:50', NULL);
INSERT INTO `c_permission` VALUES (57, 47, 'student:assignmentConsultant', '网络学生分配咨询师', '网络学生分配咨询师', '2020-06-04 15:24:35', NULL);
INSERT INTO `c_permission` VALUES (58, 39, 'studentRecycle:batchDelete', '学生信息回收站批量删除', '学生信息回收站批量删除', '2020-06-05 15:41:08', NULL);
INSERT INTO `c_permission` VALUES (59, 39, 'studentRecycle:batchRestore', '学生信息回收站批量还原', '学生信息回收站批量还原', '2020-06-05 15:44:28', NULL);
INSERT INTO `c_permission` VALUES (60, 39, 'studentRecycle:restore', '学生信息回收站还原', '学生信息回收站还原', '2020-06-05 15:44:49', NULL);
INSERT INTO `c_permission` VALUES (61, 39, 'studentRecycle:delete', '学生信息回收站删除', '学生信息回收站删除', '2020-06-05 15:45:05', NULL);
INSERT INTO `c_permission` VALUES (62, 40, 'following:batchDelete', '跟踪信息回收站批量删除', '跟踪信息回收站批量删除', '2020-06-05 15:46:45', NULL);
INSERT INTO `c_permission` VALUES (63, 40, 'following:batchRestore', '跟踪信息回收站批量还原', '跟踪信息回收站批量还原', '2020-06-05 15:47:13', NULL);
INSERT INTO `c_permission` VALUES (64, 40, 'following:restore', '跟踪信息回收站还原', '跟踪信息回收站还原', '2020-06-05 15:47:29', NULL);
INSERT INTO `c_permission` VALUES (65, 40, 'following:delete', '跟踪信息回收站删除', '跟踪信息回收站删除', '2020-06-05 15:47:46', NULL);
INSERT INTO `c_permission` VALUES (66, 41, 'unallocated:aSingleAllocate', '未分配单个分配咨询师', '未分配单个分配咨询师', '2020-06-05 15:56:41', NULL);
INSERT INTO `c_permission` VALUES (67, 42, 'fenliang:allOn', '分量全部开启', '分量全部开启', '2020-06-05 15:59:32', NULL);
INSERT INTO `c_permission` VALUES (68, 42, 'fenliang:oneOn', '分量单个开启', '分量单个开启', '2020-06-05 15:59:45', NULL);
INSERT INTO `c_permission` VALUES (69, 51, 'work:derive', '考勤导出', '考勤导出', '2020-06-05 16:01:27', NULL);
INSERT INTO `c_permission` VALUES (70, 51, 'work:sign', '考勤补签', '考勤补签', '2020-06-05 16:01:58', NULL);
INSERT INTO `c_permission` VALUES (71, 48, 'followUp:add', '跟踪访问添加', '跟踪访问添加', '2020-06-05 16:03:21', NULL);
INSERT INTO `c_permission` VALUES (72, 48, 'followUp:delete', '跟踪访问删除', '跟踪访问删除', '2020-06-05 16:03:35', NULL);
INSERT INTO `c_permission` VALUES (73, 48, 'followUp:recycle', '跟踪访问回收站', '跟踪访问回收站', '2020-06-05 16:05:00', NULL);
INSERT INTO `c_permission` VALUES (74, 48, 'followUp:update', '跟踪访问编辑', '跟踪访问编辑', '2020-06-05 16:05:38', NULL);
INSERT INTO `c_permission` VALUES (75, 47, 'student:newsFeed', '网络学生动态推送', '网络学生动态推送', '2020-06-06 21:01:19', NULL);
INSERT INTO `c_permission` VALUES (76, 0, 'client/student/myStudent.html', '我的学生管理', '我的学生管理', '2020-06-07 19:28:10', NULL);
INSERT INTO `c_permission` VALUES (77, 76, 'myStudent:show', '我的学生查看', '我的学生查看', '2020-06-07 19:30:24', NULL);
INSERT INTO `c_permission` VALUES (78, 76, 'myStudent:update', '我的学生编辑', '我的学生编辑', '2020-06-07 19:30:44', NULL);
INSERT INTO `c_permission` VALUES (79, 76, 'myStudent:delete', '我的学生删除', '我的学生删除', '2020-06-07 19:30:57', NULL);
INSERT INTO `c_permission` VALUES (80, 76, 'myStudent:recycle', '我的学生回收站', '我的学生回收站', '2020-06-09 08:57:59', NULL);
INSERT INTO `c_permission` VALUES (81, 47, 'student:daoru', '网络学生导入', '网络学生导入', '2020-06-08 23:07:45', NULL);
INSERT INTO `c_permission` VALUES (82, 47, 'student:daochu', '网络学生导出', '网络学生导出', '2020-06-08 23:08:01', NULL);
INSERT INTO `c_permission` VALUES (83, 48, 'follow:view', '跟踪访问查看', '跟踪访问查看', '2020-06-09 08:49:37', NULL);
INSERT INTO `c_permission` VALUES (84, 76, 'myStudent:daochu', '我的学生导出', '我的学生导出', '2020-06-09 08:55:51', NULL);

-- ----------------------------
-- Table structure for c_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `c_role_permission`;
CREATE TABLE `c_role_permission`  (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `p_id` int(11) NULL DEFAULT NULL,
  `standby1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字符串备用字段',
  `standby2` int(11) NULL DEFAULT NULL COMMENT '整数备用字段',
  PRIMARY KEY (`rp_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 867 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_role_permission
-- ----------------------------
INSERT INTO `c_role_permission` VALUES (312, 1, 1, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (313, 1, 18, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (314, 1, 19, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (315, 1, 30, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (316, 1, 2, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (317, 1, 3, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (318, 1, 4, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (319, 1, 5, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (320, 1, 6, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (321, 1, 7, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (322, 1, 8, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (323, 1, 35, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (324, 1, 20, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (325, 1, 21, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (326, 1, 22, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (327, 1, 23, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (328, 1, 24, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (329, 1, 25, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (330, 1, 26, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (331, 1, 27, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (332, 1, 28, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (333, 1, 29, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (334, 1, 31, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (335, 1, 32, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (336, 1, 33, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (337, 1, 34, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (533, 8, 47, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (534, 8, 52, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (535, 8, 54, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (536, 8, 75, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (592, 7, 1, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (593, 7, 18, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (594, 7, 19, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (595, 7, 30, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (596, 7, 39, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (597, 7, 40, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (598, 7, 41, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (599, 7, 42, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (600, 7, 46, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (601, 7, 47, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (602, 7, 48, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (603, 7, 49, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (604, 7, 51, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (605, 7, 2, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (606, 7, 4, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (607, 7, 20, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (608, 7, 24, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (609, 7, 25, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (610, 7, 26, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (611, 7, 27, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (612, 7, 28, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (613, 7, 29, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (614, 7, 31, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (615, 7, 32, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (616, 7, 33, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (617, 7, 34, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (618, 7, 58, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (619, 7, 59, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (620, 7, 60, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (621, 7, 61, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (622, 7, 62, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (623, 7, 63, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (624, 7, 64, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (625, 7, 65, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (626, 7, 45, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (627, 7, 66, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (628, 7, 67, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (629, 7, 68, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (630, 7, 52, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (631, 7, 53, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (632, 7, 54, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (633, 7, 55, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (634, 7, 56, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (635, 7, 57, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (636, 7, 75, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (637, 7, 71, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (638, 7, 72, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (639, 7, 73, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (640, 7, 74, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (641, 7, 69, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (642, 7, 70, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (771, 22, 1, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (772, 22, 2, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (773, 2, 39, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (774, 2, 40, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (775, 2, 41, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (776, 2, 42, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (777, 2, 47, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (778, 2, 48, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (779, 2, 51, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (780, 2, 76, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (781, 2, 58, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (782, 2, 59, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (783, 2, 60, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (784, 2, 61, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (785, 2, 62, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (786, 2, 63, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (787, 2, 64, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (788, 2, 65, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (789, 2, 45, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (790, 2, 66, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (791, 2, 67, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (792, 2, 68, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (793, 2, 52, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (794, 2, 53, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (795, 2, 54, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (796, 2, 55, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (797, 2, 56, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (798, 2, 57, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (799, 2, 75, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (800, 2, 81, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (801, 2, 82, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (802, 2, 71, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (803, 2, 72, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (804, 2, 73, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (805, 2, 74, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (806, 2, 69, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (807, 2, 70, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (808, 2, 77, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (809, 2, 78, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (810, 2, 79, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (811, 2, 80, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (839, 9, 39, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (840, 9, 40, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (841, 9, 47, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (842, 9, 48, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (843, 9, 76, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (844, 9, 58, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (845, 9, 59, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (846, 9, 60, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (847, 9, 61, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (848, 9, 62, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (849, 9, 63, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (850, 9, 64, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (851, 9, 65, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (852, 9, 53, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (853, 9, 54, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (854, 9, 55, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (855, 9, 56, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (856, 9, 75, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (857, 9, 71, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (858, 9, 72, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (859, 9, 73, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (860, 9, 74, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (861, 9, 83, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (862, 9, 77, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (863, 9, 78, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (864, 9, 79, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (865, 9, 80, NULL, NULL);
INSERT INTO `c_role_permission` VALUES (866, 9, 84, NULL, NULL);

-- ----------------------------
-- Table structure for c_roles
-- ----------------------------
DROP TABLE IF EXISTS `c_roles`;
CREATE TABLE `c_roles`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色编号',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色（用户组）名称',
  `standby1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字符串备用字段',
  `standby2` int(11) NULL DEFAULT NULL COMMENT '整数备用字段',
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_roles
-- ----------------------------
INSERT INTO `c_roles` VALUES (1, '管理员', NULL, NULL);
INSERT INTO `c_roles` VALUES (2, '咨询师经理', NULL, NULL);
INSERT INTO `c_roles` VALUES (7, '系统测试员', NULL, NULL);
INSERT INTO `c_roles` VALUES (8, '网络咨询师', NULL, NULL);
INSERT INTO `c_roles` VALUES (9, '咨询师', NULL, NULL);
INSERT INTO `c_roles` VALUES (22, '开组', NULL, NULL);

-- ----------------------------
-- Table structure for c_roles_modules
-- ----------------------------
DROP TABLE IF EXISTS `c_roles_modules`;
CREATE TABLE `c_roles_modules`  (
  `rm_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色模块中间表编号',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色表编号',
  `module_id` int(11) NULL DEFAULT NULL COMMENT '功能模块编号',
  `standby1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字符串备用字段',
  `standby2` int(11) NULL DEFAULT NULL COMMENT '整数备用字段',
  PRIMARY KEY (`rm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 337 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_roles_modules
-- ----------------------------
INSERT INTO `c_roles_modules` VALUES (239, 1, 1, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (240, 1, 3, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (241, 1, 4, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (242, 1, 5, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (243, 1, 6, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (270, 8, 2, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (271, 8, 7, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (295, 7, 1, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (296, 7, 2, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (297, 7, 3, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (298, 7, 4, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (299, 7, 5, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (300, 7, 6, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (301, 7, 7, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (302, 7, 8, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (303, 7, 44, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (304, 7, 45, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (305, 7, 48, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (306, 7, 49, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (307, 7, 50, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (308, 7, 51, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (309, 7, 54, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (310, 2, 2, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (311, 2, 7, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (312, 2, 44, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (313, 2, 45, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (314, 2, 48, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (315, 2, 50, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (316, 2, 51, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (317, 2, 54, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (318, 2, 55, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (330, 9, 2, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (331, 9, 8, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (332, 9, 48, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (333, 9, 49, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (334, 9, 55, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (335, 22, 1, NULL, NULL);
INSERT INTO `c_roles_modules` VALUES (336, 22, 3, NULL, NULL);

-- ----------------------------
-- Table structure for c_student
-- ----------------------------
DROP TABLE IF EXISTS `c_student`;
CREATE TABLE `c_student`  (
  `studnet_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生编号',
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户员工id（网络咨询师）',
  `user_id2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工编号（咨询师）',
  `s_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `s_age` int(11) NULL DEFAULT NULL COMMENT '学生的年龄',
  `s_gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生性别',
  `s_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生电话',
  `s_perstate` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国籍',
  `s_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `s_source` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源渠道：学生是通过百度、必应、360等等搜索器了解学校并来到的',
  `s_source_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '“www.bing.com”、“www.baidu.com”等等',
  `s_source_keyword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '“新乡职业”、“新乡技术学校”等等',
  `s_degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生学历',
  `s_qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生qq号码',
  `s_weixin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生微信号码',
  `s_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前状态（还在考虑中，已录入，已进入别的学校 等等）',
  `s_counselor_remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前咨询师对这个学生写的备注信息',
  `s_score` int(255) NULL DEFAULT NULL COMMENT '咨询师对学生打分，是否符合招生标准(对学生初步了解，学生什么时候可以报名)',
  `s_curriculum` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生想报什么课程',
  `s_is_valia` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是：继续填写，无效原因不能填写 否：只能填写无效原因，其他信息全部禁止填写',
  `s_invalid_cause` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '无效原因',
  `s_is_callback` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否首次回访',
  `s_callback_time` datetime(0) NULL DEFAULT NULL COMMENT '是否首次回访',
  `s_is_visit` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否上门',
  `s_visit_time` datetime(0) NULL DEFAULT NULL COMMENT '上门时间',
  `s_handsel` decimal(8, 2) NULL DEFAULT NULL COMMENT '(n,m)表示数值中共有n位数，其中整数n-m位，小数m位。',
  `s_handsel_time` date NULL DEFAULT NULL COMMENT '定金时间',
  `s_is_pay` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否完成缴费',
  `s_pay_time` date NULL DEFAULT NULL COMMENT '缴费时间',
  `s_pay_handsel` decimal(8, 2) NULL DEFAULT NULL COMMENT '缴费金额',
  `s_is_return_premium` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否退费',
  `s_return_premium_case` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退费原因',
  `s_is_return_premium_time` datetime(0) NULL DEFAULT NULL COMMENT '退费时间',
  `s_is_in_class` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该生是否分配班级',
  `s_in_class_time` datetime(0) NULL DEFAULT NULL COMMENT '进入班级时间',
  `s_allot` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '是否分配咨询师 true已分配 |false未分配',
  `standby1` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `s_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '学生创建时间',
  PRIMARY KEY (`studnet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_student
-- ----------------------------
INSERT INTO `c_student` VALUES ('149fde1f-c8b1-4b4a-9764-5ae1ebecae34', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', NULL, '姚璐璐', 21, '男', '15938096012', NULL, NULL, '谷歌', '必应', '高薪', '研究生', '216546', 'yaolulu', '在读', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'false', '璐璐。', '2020-06-09 08:21:20');
INSERT INTO `c_student` VALUES ('17534c55-cda3-4f76-9541-8eca4584aaa2', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '郝爱民', 20, '男', '15938096021', NULL, NULL, '必应', '谷歌', '高薪', '研究生', '1582216546', 'fuyou0000', '在读', NULL, 5, 'C++', '否', NULL, '否', NULL, '否', NULL, NULL, NULL, '', NULL, NULL, '否', NULL, NULL, '否', NULL, 'true', '他喜欢编程。', '2020-06-05 08:39:55');
INSERT INTO `c_student` VALUES ('306a5d52-dedf-4ce1-ba65-3a3a20ef9c84', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '刘备', 25, '男', '18738096023', NULL, NULL, '必应', '必应', '高薪', '研究生', '9082216546', 'liubei', '在读', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '勿以恶小而为之，勿以善小而不为。惟贤惟德，能服于人。', '2020-06-08 03:23:10');
INSERT INTO `c_student` VALUES ('3efdb7f5-d30c-4fee-ae6e-74a4167d7b9e', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '刘何方', 28, '男', '17838096022', NULL, NULL, '微博', '必应', '高薪', '家里蹲', '2882216541', 'liuhefang', '其他', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'true', '卖东西的。', '2020-06-08 03:16:35');
INSERT INTO `c_student` VALUES ('440c1574-a497-46ba-9890-c1f4a6da49a5', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '萧伯纳', 28, '男', '13000119999', NULL, NULL, '谷歌', '谷歌', '高薪', '研究生', '2216546', 'xiaobona', '其他', NULL, 5, NULL, '否', NULL, '否', NULL, '否', NULL, NULL, NULL, '', NULL, NULL, '否', NULL, NULL, '否', NULL, '0', '自我控制是最强者的本能。', '2020-06-08 03:22:16');
INSERT INTO `c_student` VALUES ('69b99da9-6217-4095-8594-ff76d1212e26', '464efa97-5347-4dc6-b772-5dac1caa7409', NULL, '闫鑫', 23, '男', '15938096129', NULL, NULL, '必应', '必应', '高薪', '研究生', '8882216541', 'yanxin', '在读', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', '闫鑫，1.8.', '2020-06-09 07:17:15');
INSERT INTO `c_student` VALUES ('6d544b72-de26-46f6-bca2-8790bf77e1a0', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '刘兴发', 21, '男', '15938196021', NULL, NULL, '必应', '必应', '高薪', '研究生', '216541', 'liuxingfa', '在读', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'true', '班长。', '2020-06-09 07:42:59');
INSERT INTO `c_student` VALUES ('74154482-fa96-441c-a392-106ad12ef78c', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '小黑', 18, '男', '15603828245', NULL, NULL, '谷歌', '谷歌', '高薪', '本科', '12312312312', '34qtead4twds', '在读', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'true', NULL, NULL);
INSERT INTO `c_student` VALUES ('8a71e2f0-55a9-41bb-9cd7-6c8de763021b', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '5475ec78-7fb2-4bd6-b578-8b60b2271a1a', '王黎明', 21, '男', '15938096033', NULL, NULL, '谷歌', '必应', '高薪', '研究生', '8888216546', 'wangliming', '在读', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'true', '王黎明', '2020-06-09 07:35:28');
INSERT INTO `c_student` VALUES ('c8758618-3261-4d3a-ba96-96dff33abc48', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '歌德', 40, '男', '17812323211', NULL, NULL, '谷歌', '谷歌', NULL, '研究生', '30021000', 'gede123456', '其他', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'true', '你若要喜爱你自己的价值，你就得给世界创造价值。', '2020-06-08 03:19:13');
INSERT INTO `c_student` VALUES ('ee64b0a0-1e93-40f9-be5a-5a8271ef932b', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '刘堃', 23, '男', '15938096029', NULL, NULL, '必应', '必应', '高薪', '研究生', '1582216541', 'liukunaini', '就业', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'true', '刘堃的电话号码。', '2020-06-08 03:14:12');

-- ----------------------------
-- Table structure for c_student_copy
-- ----------------------------
DROP TABLE IF EXISTS `c_student_copy`;
CREATE TABLE `c_student_copy`  (
  `studnet_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生编号',
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户员工id（网络咨询师）',
  `user_id2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工编号（咨询师）',
  `s_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `s_age` int(11) NULL DEFAULT NULL COMMENT '学生的年龄',
  `s_gender` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生性别',
  `s_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生电话',
  `s_perstate` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '国籍',
  `s_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `s_source` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源渠道：学生是通过百度、必应、360等等搜索器了解学校并来到的',
  `s_source_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '“www.bing.com”、“www.baidu.com”等等',
  `s_source_keyword` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '“新乡职业”、“新乡技术学校”等等',
  `s_degree` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生学历',
  `s_qq` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生qq号码',
  `s_weixin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生微信号码',
  `s_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前状态（还在考虑中，已录入，已进入别的学校 等等）',
  `s_counselor_remark` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '当前咨询师对这个学生写的备注信息',
  `s_score` int(255) NULL DEFAULT NULL COMMENT '咨询师对学生打分，是否符合招生标准(对学生初步了解，学生什么时候可以报名)',
  `s_curriculum` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生想报什么课程',
  `s_is_valia` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是：继续填写，无效原因不能填写 否：只能填写无效原因，其他信息全部禁止填写',
  `s_invalid_cause` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '无效原因',
  `s_is_callback` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否首次回访',
  `s_callback_time` datetime(0) NULL DEFAULT NULL COMMENT '是否首次回访',
  `s_is_visit` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否上门',
  `s_visit_time` datetime(0) NULL DEFAULT NULL COMMENT '上门时间',
  `s_handsel` decimal(8, 2) NULL DEFAULT NULL COMMENT '(n,m)表示数值中共有n位数，其中整数n-m位，小数m位。',
  `s_handsel_time` date NULL DEFAULT NULL COMMENT '定金时间',
  `s_is_pay` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否完成缴费',
  `s_pay_time` date NULL DEFAULT NULL COMMENT '缴费时间',
  `s_pay_handsel` decimal(8, 2) NULL DEFAULT NULL COMMENT '缴费金额',
  `s_is_return_premium` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否退费',
  `s_return_premium_case` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退费原因',
  `s_is_return_premium_time` datetime(0) NULL DEFAULT NULL COMMENT '退费时间',
  `s_is_in_class` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该生是否分配班级',
  `s_in_class_time` datetime(0) NULL DEFAULT NULL COMMENT '进入班级时间',
  `s_allot` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否分配咨询师 true已分配 |false未分配',
  `standby1` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `s_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '学生创建时间',
  PRIMARY KEY (`studnet_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_student_copy
-- ----------------------------
INSERT INTO `c_student_copy` VALUES ('bbc5c235-2db4-47a1-bd43-84acd41c4eb0', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '580a5d29-94f3-4511-b17b-c1faf5902feb', '罗曼·罗兰', 25, '女', '13438096021', NULL, NULL, '谷歌', '必应', '高薪', '研究生', '1282216546', 'luomanluiolan', '在读', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'true', '先相信自己，然后别人才会相信你。', '2020-06-08 03:32:34');

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user`  (
  `user_id` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '32位唯一UUID',
  `u_login_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录用户名',
  `u_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户真实姓名',
  `u_password` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'MD5加密',
  `u_lock_out` int(11) NULL DEFAULT 0 COMMENT '0未锁定，1锁定',
  `u_last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `u_create_time` datetime(0) NULL DEFAULT NULL COMMENT '账户创建时间',
  `u_psd_wrong` int(11) NULL DEFAULT NULL COMMENT '密码错误次数',
  `u_lock_time` datetime(0) NULL DEFAULT NULL COMMENT '账号锁定时间',
  `u_protect_email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密保手机号',
  `u_protect_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密保手机号',
  `u_id_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `u_standby2` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户资料备注',
  `u_gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `u_head_portrait` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `u_remark` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `u_auto_allot` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'false' COMMENT '分量状态（是否开启自动分配）\"true\"开启 \"false\"默认不开启(针对于咨询师)',
  `u_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户在线还是隐藏',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES ('0626ac64-9ce7-4b99-a114-715dd05050ca', '姚林辉', '姚林辉', '6f21f76e619c20808845eb8323160fac', 0, '2020-06-09 06:40:21', '2020-05-17 01:29:08', 1, '2020-06-06 22:51:17', '1582216545@qq.com', '15938096024', '412827200004123456', NULL, '男', '../../../images/16226381-b09a-4f64-9f4f-a1ec9c7cbc4e.jpg', '美丽的人啊，你哈', 'false', 'online');
INSERT INTO `c_user` VALUES ('0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师', '许巍', '431ebb4bd6201821aa734318ebf0be9e', 0, '2020-06-09 07:47:45', '2020-05-19 00:29:06', 0, '2020-06-04 18:33:15', '1451534345@qq.com', '15938096025', '411627200011123456', NULL, '男', '../../../images/fc001a07-e81d-488d-ab65-d453c65b3d02.jpg', '宝贝，他们说我不爱你。好吧。', 'false', 'online');
INSERT INTO `c_user` VALUES ('1', '管理员', '韩寒', '6f21f76e619c20808845eb8323160fac', 0, '2020-06-09 17:51:11', '2020-05-06 08:42:04', 1, '2020-05-29 18:50:51', '1582216546@qq.com', '15938096020', '412827200004123456', '韩寒，1982年9月23日出生于上海市金山区亭林镇，中国作家、导演、职业赛车手。', '男', '../../../images/3be4ccd5-4151-4ca9-a133-fb9d5d120fd5.jpg', '你拥有我的不只是今夜', 'false', 'online');
INSERT INTO `c_user` VALUES ('21986948-1adb-476a-a505-1df5baa88788', '咨询师经理', '伍佰', '431ebb4bd6201821aa734318ebf0be9e', 0, '2020-06-09 07:47:20', '2020-05-24 03:05:11', 0, NULL, '13412312@qq.com', '15603828212', '611627200011123456', NULL, '男', '../../../images/f3beb631-04d5-464d-9108-264dad10005e.jpg', '随便吧，随便吧', 'true', 'online');
INSERT INTO `c_user` VALUES ('464efa97-5347-4dc6-b772-5dac1caa7409', '周云蓬', '周云蓬', 'a856a9260a9dcf80eec36cfffaa1e6a6', 0, '2020-06-09 07:15:20', '2020-06-08 22:20:08', 1, '2020-06-09 07:14:47', '2282216546@qq.com', '15338096024', '412827200004284039', '周云蓬，1970年12月15日出生于辽宁省，中国内地民谣男歌手、诗人，毕业于长春大学中文系。\r\n9岁时失明，15岁弹吉他，19岁上大学，21岁写诗，24岁开始随处漂泊。周云蓬的诗歌《不会说话的爱情》获得2011年度人民文学奖诗歌奖。', '男', '../../../images/52530f0d-a7a3-487b-8ce3-f6f2a742fafd.jpg', NULL, 'false', 'online');
INSERT INTO `c_user` VALUES ('4ba70478-2412-4e89-a85e-82c881dc9fe4', '尧十三', '尧十三', '69d6f5e6a3910a978db031f18db133f6', 0, '2020-06-03 15:44:45', '2020-06-03 07:38:08', 0, NULL, '1582216540@qq.com', '15938096021', '422827200004284001', '尧十三，原名唐尧，1986年8月25日出生于贵州省毕节市织金县，中国内地男歌手，毕业于武汉大学医学院临床专业。', '男', '../../../images/e50dedb6-fe5e-4aa9-b2c5-3d0b27596b60.jpg', NULL, 'false', 'online');
INSERT INTO `c_user` VALUES ('5475ec78-7fb2-4bd6-b578-8b60b2271a1a', '张玮玮', '张玮玮', 'a3f61897839902062fd28478e7be91fb', 0, '2020-06-09 07:33:18', '2020-06-08 22:26:50', 0, NULL, 'zhangweiwei@youxaing.com', '15938096124', '412827200004281235', '张玮玮，1976年出生于甘肃省白银市，中国内地创作型民谣男歌手，河乐队成员。', '男', '../../../images/334be422-44bf-404f-a3f4-a0d3d4252c0c.jpg', NULL, 'true', 'online');
INSERT INTO `c_user` VALUES ('580a5d29-94f3-4511-b17b-c1faf5902feb', '咨询师', '张国荣', '431ebb4bd6201821aa734318ebf0be9e', 0, '2020-06-09 08:31:57', '2020-05-24 01:39:27', 0, NULL, '1231321312@qq.com', '15603824552', '412627200011123456', NULL, '男', '../../../images/62a6d409-ab7d-45c3-a982-b36cd9e9d1f1.jpg', '我愿意为你死去', 'true', 'online');
INSERT INTO `c_user` VALUES ('afd330d5-645e-4dd9-8c28-ff0a7063cac2', '李志', '李志', '431ebb4bd6201821aa734318ebf0be9e', 0, '2020-06-08 03:26:41', '2020-05-24 03:14:50', 1, '2020-05-29 18:30:04', '132412312@qq.com', '15603828211', '613627200011123456', NULL, '男', '../../../images/6973475d-d0a3-4561-917c-a3a65eef9827.jpg', '可是，他们说我不爱你', 'true', 'online');
INSERT INTO `c_user` VALUES ('c4d43fd1-86d1-4274-9761-fe1ddaf1eab2', '钟立风', '钟立风', '80c0b26fbe0ec2e637735250969c8fed', 0, NULL, '2020-06-08 22:23:18', 0, NULL, 'zhonglifeng@youxiang.com', '15938096123', '412827200004281234', '钟立风，1974年2月16日出生于浙江省丽水市遂昌县，中国内地民谣男歌手、作家。', '男', '../../../images/d4d8d99c-f3c8-419a-bdfc-da8328cff540.jpg', NULL, 'false', NULL);
INSERT INTO `c_user` VALUES ('f0632614-5fb8-4c21-b093-83545cc64148', '赵雷', '赵雷', '11b3fa153883c4bb70002c9585340598', 0, NULL, '2020-06-08 22:29:21', 0, NULL, 'zhaolei@youxiang.com', '15938096125', '412827200004281236', '赵雷，1986年7月20日生于北京，中国内地民谣歌手、音乐人。', '男', '../../../images/a4474b11-da4d-44ac-8b59-1e8c5d7e4640.jpg', NULL, 'false', NULL);

-- ----------------------------
-- Table structure for c_user_checks
-- ----------------------------
DROP TABLE IF EXISTS `c_user_checks`;
CREATE TABLE `c_user_checks`  (
  `uc_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `u_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uc_check_in_time` datetime(0) NULL DEFAULT NULL,
  `uc_check_out_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uc_check_statue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `standby2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uc_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_user_checks
-- ----------------------------
INSERT INTO `c_user_checks` VALUES ('0e21c7e1-df92-4b17-8578-adffa16b6944', '21986948-1adb-476a-a505-1df5baa88788', '咨询师经理', '2020-06-09 07:07:44', '2020-06-09 07:07:46', '2', NULL);
INSERT INTO `c_user_checks` VALUES ('0e3285c2-dd00-48a8-8617-c00ba77e02c2', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-30 22:58:21', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('130b1649-e202-49dd-96bf-c81413b76e9a', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师', '2020-06-04 00:05:47', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('160ce9b5-f085-49e2-bd82-5d8e7d1bc12b', '1', '管理员', '2020-06-09 06:15:00', '2020-06-09 06:15:03', '2', NULL);
INSERT INTO `c_user_checks` VALUES ('18b3b44b-af03-4792-9580-c393da884cfb', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师', '2020-06-03 23:49:07', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('1a7105cb-cf08-484f-bc75-5f7a646047be', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-05-25 00:03:25', '2020-05-25 00:00:00', '2', NULL);
INSERT INTO `c_user_checks` VALUES ('1a8b2e55-1838-4ca7-9561-2786462f4d64', '464efa97-5347-4dc6-b772-5dac1caa7409', '周云蓬', '2020-06-09 07:15:23', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('1c3ecaa8-e44c-4256-b649-759319aa9163', '580a5d29-94f3-4511-b17b-c1faf5902feb', '咨询师', '2020-06-08 03:28:10', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('20ba9345-db1c-44bd-8381-8e23c726abb5', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-28 15:51:33', '2020-05-28 00:00:00', '2', NULL);
INSERT INTO `c_user_checks` VALUES ('39bb94a3-7476-4ac1-a938-88a9441d5ec0', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-05-31 08:49:49', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('3ab4bc1c-f567-4e65-aa8c-60a301c14b23', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师', '2020-06-06 10:37:24', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('3b92b53c-b77e-48a6-8969-ac90da45c593', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-06-01 01:00:21', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('402f8367-8043-477e-9d80-67caa13cb26c', '1', '管理员', '2020-06-04 15:25:45', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('4114ec2e-daef-4dbf-98f2-41fc89772b86', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '李志', '2020-06-08 03:24:28', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('4b8b7287-412b-45cb-a012-cef37feb8f6b', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-31 23:26:59', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('4c7b0230-b1f6-4bb1-ac62-e7df97c5f653', '0626ac64-9ce7-4b99-a114-715dd05050ca', '姚林辉', '2020-06-05 15:08:07', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('512b2878-cf88-49d9-b293-84d6079e4bfa', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '咨询师风狼2', '2020-05-27 06:44:49', '2020-05-28 00:00:00', '2', NULL);
INSERT INTO `c_user_checks` VALUES ('5267d60e-81b3-46d8-b41b-b75412a79b59', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-05-27 21:26:20', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('5a75fbcc-b993-4334-8c67-6276f0d3c53a', '1', '管理员', '2020-06-01 16:32:15', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('6339148f-0ea5-4735-b77e-148473eef51b', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师', '2020-06-05 08:19:04', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('6aae2428-37ab-4123-9a75-575c4a0d5cd2', '0626ac64-9ce7-4b99-a114-715dd05050ca', '姚林辉', '2020-06-07 00:18:08', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('726c91d3-46a8-46e4-a61c-d73b9806ff03', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-05-26 08:06:46', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('75fa9123-3d49-4f2b-a446-fab733594d76', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '李志', '2020-06-06 21:06:09', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('7605018d-ce08-4bcb-bbcb-284a01ed5b3b', '1', '管理员', '2020-06-03 01:11:32', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('77614177-09fb-486f-be82-afd655eaeb43', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-06-01 16:37:19', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('847bb4d4-c626-4c07-947e-0aa4159ad297', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-05-29 17:29:59', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('857646f5-41cc-4540-b5cd-e243fc3def99', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-05-28 08:58:30', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('8ede4ecb-e9c2-46bb-9be3-29ddbdb8ad6c', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-21 08:41:11', '2020-05-25 00:00:00', '2', NULL);
INSERT INTO `c_user_checks` VALUES ('95476a68-bf34-4522-9699-5cf77d77529f', '1', '管理员', '2020-05-29 10:57:32', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('a528c34a-c946-494d-a239-d01c6eb92fd6', '1', '管理员', '2020-06-07 00:19:12', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('a5c09df3-7404-4d29-9426-d05dfb2df64d', '580a5d29-94f3-4511-b17b-c1faf5902feb', '咨询师', '2020-06-05 08:34:30', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('a842ba45-dafd-4c5a-9a1b-f27268b11ea0', '0626ac64-9ce7-4b99-a114-715dd05050ca', '姚林辉', '2020-06-06 22:51:30', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('ae127954-e27d-4641-85a9-e459db6fc776', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-05-24 22:47:40', '2020-05-25 00:00:00', '2', NULL);
INSERT INTO `c_user_checks` VALUES ('af014dac-76cb-49cd-b603-f107a4901e24', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-20 11:38:53', '2020-05-20 11:39:27', '2', '辞职1dnk');
INSERT INTO `c_user_checks` VALUES ('b2eb4e95-c275-410a-a349-5f48a31879e3', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师', '2020-06-09 07:13:14', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('b32d91e3-cbfa-4c30-9d3a-43a8e5d3de53', '580a5d29-94f3-4511-b17b-c1faf5902feb', '咨询师', '2020-06-04 15:11:55', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('b3c9a785-1922-44bc-9aba-d5a24813f7b3', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-06-02 07:08:04', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('b501dd26-ef44-4429-8d96-0294a1837e27', '580a5d29-94f3-4511-b17b-c1faf5902feb', '咨询师', '2020-06-03 23:47:52', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('b55455b5-c700-410c-b5c0-657e1dcaa0e0', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '咨询师风狼2', '2020-06-02 09:25:02', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('bb22eadb-c7e5-4307-a5f4-55bbe728522d', '1', '管理员', '2020-06-08 02:23:40', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('bbfd1172-7e75-4b69-bf7b-996ca828c787', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-23 07:32:38', NULL, '2', NULL);
INSERT INTO `c_user_checks` VALUES ('bd62e285-6dfd-4cb1-9001-dea0fdd4c826', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '咨询师风狼2', '2020-05-29 10:52:28', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('c206e918-6558-4129-aa99-a321104b67c4', '21986948-1adb-476a-a505-1df5baa88788', '咨询师经理', '2020-06-08 03:10:52', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('c3adb1ed-9fbe-4065-bfa1-11a3b240709e', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-29 17:26:45', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('c404c727-c341-4b0d-bfcd-eea6d7e95ac9', '1', '管理员', '2020-06-06 18:01:44', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('c9aa4122-3ba1-40e2-9126-15fe9cecfcff', '0626ac64-9ce7-4b99-a114-715dd05050ca', '姚林辉', '2020-06-04 16:11:11', '2020-06-04 16:11:26', '2', '我去女装了。');
INSERT INTO `c_user_checks` VALUES ('cc6b9edc-59c3-4a78-bf63-3301e8fcf363', '21986948-1adb-476a-a505-1df5baa88788', '咨询师经理', '2020-06-07 19:33:10', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('cfa50d3e-93af-454c-bcc6-a90ebe3851b6', '635d9fb0-996b-4326-a8f3-0ee84163c59f', '万晓利', '2020-06-09 06:41:50', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('daeabae2-d968-475f-8289-4c1e179bb474', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师风狼', '2020-05-30 10:48:33', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('e207e2f2-1f90-4723-88d9-f3f9a5322567', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-22 08:23:44', '2020-05-22 20:05:43', '2', NULL);
INSERT INTO `c_user_checks` VALUES ('e48a5196-eae7-4dad-b668-a12efb9329d6', '1', '管理员', '2020-06-02 07:47:11', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('e56cb6de-11fa-416f-b123-803b09767d21', '0626ac64-9ce7-4b99-a114-715dd05050ca', '测试员', '2020-05-24 22:46:35', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('e5ab3703-8bc0-4538-93b0-d6e343997675', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '李志', '2020-06-04 15:20:04', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('e6678d14-c4da-4759-98c0-c2432ead98b2', '1', '管理员', '2020-06-05 15:08:38', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('e8f506bb-fe65-4368-8223-a78645d3960c', '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', '网络咨询师', '2020-06-08 03:11:36', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('eb1fd617-3def-41f1-a937-f97126df5d66', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '咨询师风狼2', '2020-05-28 17:51:03', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('ec546668-bcf9-4819-af90-f52e7dd3c2d4', 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', '李志', '2020-06-07 21:10:27', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('ecc53a57-dd2e-4d64-a18b-155b5365aef0', '580a5d29-94f3-4511-b17b-c1faf5902feb', '咨询师', '2020-06-09 00:08:37', NULL, '1', NULL);
INSERT INTO `c_user_checks` VALUES ('f2f6301d-a535-44f2-bf58-8776cc6df071', '5475ec78-7fb2-4bd6-b578-8b60b2271a1a', '张玮玮', '2020-06-09 07:33:24', NULL, '1', NULL);

-- ----------------------------
-- Table structure for c_user_roles
-- ----------------------------
DROP TABLE IF EXISTS `c_user_roles`;
CREATE TABLE `c_user_roles`  (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户角色中间表',
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色编号',
  `standby1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字符串备用字段',
  `standby2` int(11) NULL DEFAULT NULL COMMENT '整数备用字段',
  PRIMARY KEY (`ur_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of c_user_roles
-- ----------------------------
INSERT INTO `c_user_roles` VALUES (7, '1', 1, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (9, 'e9aa632c-339d-4189-8f3a-1883e45d8786', 2, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (10, 'e9aa632c-339d-4189-8f3a-1883e45d8786', 7, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (11, 'e9aa632c-339d-4189-8f3a-1883e45d8786', 1, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (12, 'e9aa632c-339d-4189-8f3a-1883e45d8786', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (13, 'e9aa632c-339d-4189-8f3a-1883e45d8786', 9, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (14, '92b50536-6d61-4b2b-82d4-e4b0e6ce51a9', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (16, '0c1ebf42-5bd5-4655-8758-a5fe6f1ae07a', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (25, '4a240668-7a9d-406b-83fa-1f379ba8c029', 2, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (26, '4a240668-7a9d-406b-83fa-1f379ba8c029', 7, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (27, '4a240668-7a9d-406b-83fa-1f379ba8c029', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (28, '4a240668-7a9d-406b-83fa-1f379ba8c029', 1, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (29, '4a240668-7a9d-406b-83fa-1f379ba8c029', 9, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (30, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 2, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (31, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 7, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (32, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (33, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 1, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (34, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 9, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (35, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 7, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (36, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (37, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 1, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (38, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 9, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (40, '10e7fde7-a05e-4080-9a03-092ce4fc08ef', 7, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (41, '0626ac64-9ce7-4b99-a114-715dd05050ca', 11, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (45, '21986948-1adb-476a-a505-1df5baa88788', 2, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (47, '24524226-3fbe-4501-a58b-cf53f66ae696', 9, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (48, '4ba70478-2412-4e89-a85e-82c881dc9fe4', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (49, 'afd330d5-645e-4dd9-8c28-ff0a7063cac2', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (50, '580a5d29-94f3-4511-b17b-c1faf5902feb', 9, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (51, '0626ac64-9ce7-4b99-a114-715dd05050ca', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (52, '635d9fb0-996b-4326-a8f3-0ee84163c59f', 2, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (56, 'c4d43fd1-86d1-4274-9761-fe1ddaf1eab2', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (57, '464efa97-5347-4dc6-b772-5dac1caa7409', 8, NULL, NULL);
INSERT INTO `c_user_roles` VALUES (58, '5475ec78-7fb2-4bd6-b578-8b60b2271a1a', 9, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
