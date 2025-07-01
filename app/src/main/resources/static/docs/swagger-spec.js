window.swaggerSpec={
  "openapi" : "3.0.1",
  "info" : {
    "title" : "Starter API Specification",
    "description" : "Starter description",
    "version" : "0.0.2"
  },
  "servers" : [ {
    "url" : "http://localhost:8080/"
  } ],
  "tags" : [ ],
  "paths" : {
    "/retrospects" : {
      "post" : {
        "tags" : [ "Retrospect" ],
        "summary" : "회고 생성",
        "description" : "회고 생성",
        "operationId" : "create-retrospect",
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/retrospects-1830130240"
              },
              "examples" : {
                "create-retrospect" : {
                  "value" : "{\n  \"goalId\" : \"goal123\",\n  \"planId\" : \"plan456\",\n  \"content\" : \"회고 내용입니다.\"\n}"
                }
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "201",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/retrospects-1554052329"
                },
                "examples" : {
                  "create-retrospect" : {
                    "value" : "{\n  \"data\" : {\n    \"id\" : \"retrospect123\"\n  }\n}"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/samples" : {
      "post" : {
        "tags" : [ "Sample" ],
        "summary" : "도메인 생성",
        "description" : "도메인 생성",
        "operationId" : "create-sample",
        "requestBody" : {
          "content" : {
            "application/json" : {
              "schema" : {
                "$ref" : "#/components/schemas/samples-510269443"
              },
              "examples" : {
                "create-sample" : {
                  "value" : "{\n  \"name\" : \"이름\",\n  \"email\" : \"메일\",\n  \"date\" : \"2025-07-01\"\n}"
                }
              }
            }
          }
        },
        "responses" : {
          "201" : {
            "description" : "201",
            "content" : {
              "application/json" : {
                "schema" : {
                  "$ref" : "#/components/schemas/samples875045187"
                },
                "examples" : {
                  "create-sample" : {
                    "value" : "{\n  \"data\" : {\n    \"id\" : \"id\"\n  }\n}"
                  }
                }
              }
            }
          }
        }
      }
    }
  },
  "components" : {
    "schemas" : {
      "samples-510269443" : {
        "type" : "object",
        "properties" : {
          "date" : {
            "type" : "string",
            "description" : "날짜"
          },
          "name" : {
            "type" : "string",
            "description" : "이름"
          },
          "email" : {
            "type" : "string",
            "description" : "이메일"
          }
        }
      },
      "retrospects-1554052329" : {
        "type" : "object",
        "properties" : {
          "data" : {
            "type" : "object",
            "properties" : {
              "id" : {
                "type" : "string",
                "description" : "회고 ID"
              }
            }
          }
        }
      },
      "retrospects-1830130240" : {
        "type" : "object",
        "properties" : {
          "goalId" : {
            "type" : "string",
            "description" : "목표 ID"
          },
          "planId" : {
            "type" : "string",
            "description" : "계획 ID"
          },
          "content" : {
            "type" : "string",
            "description" : "회고 내용"
          }
        }
      },
      "samples875045187" : {
        "type" : "object",
        "properties" : {
          "data" : {
            "type" : "object",
            "properties" : {
              "id" : {
                "type" : "string",
                "description" : "ID"
              }
            }
          }
        }
      }
    },
    "securitySchemes" : {
      "bearerAuth" : {
        "type" : "http",
        "scheme" : "bearer",
        "bearerFormat" : "JWT",
        "name" : "Authorization",
        "in" : "header",
        "description" : "Use 'your-access-token' as the value of the Authorization header"
      }
    }
  },
  "security" : [ {
    "bearerAuth" : [ ]
  } ]
}