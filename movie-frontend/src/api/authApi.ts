import axiosInstance from './axiosConfig';
import type { LoginRequest, LoginResponse, RegisterRequest, User } from '@/types/auth.types';

export const authApi = {
  // Register normal user
  registerUser: async (data: RegisterRequest): Promise<User> => {
    const response = await axiosInstance.post('/auth/registernormaluser', data);
    return response.data;
  },

  // Login
  login: async (data: LoginRequest): Promise<{ token: string; user: User }> => {
    const response = await axiosInstance.post('/auth/login', data);
    const { jwtToken, username, roles } = response.data;
    
    // Transform backend response to match frontend User interface
    return {
      token: jwtToken,
      user: {
        id: 0, // Backend doesn't return ID in login response
        username,
        email: '', // Backend doesn't return email in login response
        roles,
      },
    };
  },

  // Register admin user (admin only)
  registerAdmin: async (data: RegisterRequest): Promise<User> => {
    const response = await axiosInstance.post('/admin/registeradminuser', data);
    return response.data;
  },
};
