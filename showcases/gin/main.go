package main

import "github.com/gin-gonic/gin"
import "net/http"

import (
	"log"
	"os"
)

func setupRouter() *gin.Engine {
	r := gin.Default()

	// Get user value
	r.GET("/api/healthz", func(c *gin.Context) {
		c.Status(http.StatusOK)
	})

	return r
}

func main() {
	logx := log.New(os.Stdout, "hurl-example:", log.LstdFlags)

	runner := setupRouter()
	if runner != nil {
		var result = runner.Run(":8002")
		if result != nil {
			logx.Println("Shutdown")
		} else {
			logx.Println("Shutdown with err")
		}
	}
}
