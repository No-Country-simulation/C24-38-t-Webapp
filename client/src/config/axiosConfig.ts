import { API } from '@/constants/API';
import axios from 'axios';
export const apiClient = axios.create({
  baseURL: API,
  headers: {
    'Content-type': 'application/json',
  },
});
