import { useAuthStore } from '@/store/authStore';

export const useAuth = () => {
  const { user, token, isAuthenticated, isAdmin, setAuth, logout, checkAuth } = useAuthStore();

  return {
    user,
    token,
    isAuthenticated,
    isAdmin,
    setAuth,
    logout,
    checkAuth,
  };
};
