import axios from 'axios';

const BASE_URL = '/system/user';

export interface BasicInfoModel {
  username: string;
  nickname: string;
  gender: number;
}

export interface AvatarRes {
  avatar: string;
}

export function uploadAvatar(data: FormData) {
  return axios.post<AvatarRes>(`${BASE_URL}/avatar`, data);
}

export interface UserBasicInfoUpdateReq {
  nickname: string;
  gender: number;
}

export function updateBasicInfo(req: UserBasicInfoUpdateReq) {
  return axios.patch(`${BASE_URL}/basic/info`, req);
}

export interface UserPasswordUpdateReq {
  oldPassword: string;
  newPassword: string;
}

export function updatePassword(req: UserPasswordUpdateReq) {
  return axios.patch(`${BASE_URL}/password`, req);
}

export interface UserPhoneUpdateReq {
  newPhone: string;
  captcha: string;
  currentPassword: string;
}

export function updatePhone(req: UserPhoneUpdateReq) {
  return axios.patch(`${BASE_URL}/phone`, req);
}

export interface UserEmailUpdateReq {
  newEmail: string;
  captcha: string;
  currentPassword: string;
}

export function updateEmail(req: UserEmailUpdateReq) {
  return axios.patch(`${BASE_URL}/email`, req);
}

export interface UserSocialBindRecord {
  source: string;
  description: string;
}

export function listSocial() {
  return axios.get<UserSocialBindRecord[]>(`${BASE_URL}/social`);
}

export function bindSocial(source: string, req: any) {
  return axios.post(`${BASE_URL}/social/${source}`, req);
}

export function unbindSocial(source: string) {
  return axios.delete(`${BASE_URL}/social/${source}`);
}
