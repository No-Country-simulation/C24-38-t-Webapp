import { LoginCredentials } from "@/interfaces/auth.interface"
import { AuthService } from "@/services/auth.service"
import { useMutation, useQueryClient } from "@tanstack/react-query"
import { useNavigate } from "react-router-dom"

export const useAuth = () => {
    const queryClient = useQueryClient()
    const navigate = useNavigate()

    const login = useMutation({
        mutationFn: (credentials: LoginCredentials) => AuthService.login(credentials),
        onSuccess: (data) => {
            localStorage.setItem('token', JSON.stringify(data.message))
            navigate("/home")
            queryClient.invalidateQueries({ queryKey: ['user-data'] })
        },
        onError: (error) => {
            console.error("Login failed:", error)
        }
    })

    const logout = () => {
        localStorage.removeItem('token')
        queryClient.clear()
        navigate('/login')
    }

    return {
        login: login.mutate,
        loginError: login.error,
        isLoginLoading: login.isPending,
        logout,
        isLoggedIn: !!localStorage.getItem('token')
    }
}