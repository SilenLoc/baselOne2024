package main

import "github.com/gin-gonic/gin"
import "net/http"

func setupRouter() *gin.Engine {
	r := gin.Default()

	// Get user value
	r.GET("/healthz", func(c *gin.Context) {
		c.Status(http.StatusOK)
	})

	return r
}

func main() {
	r := setupRouter()
	// Listen and Server in 0.0.0.0:8080
	r.Run(":8002")
}