package org.sid.inventoryservice.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.jspecify.annotations.Nullable;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.List;

@Component
public class GraphQlExceptionHandler extends DataFetcherExceptionResolverAdapter {


    @Override
    protected @Nullable GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return new GraphQLError() {
            @Override
            public String getMessage() {
                return ex.getMessage() ;
            }

            @Override
            public @Nullable List<SourceLocation> getLocations() {
                return List.of();
            }

            @Override
            public ErrorClassification getErrorType() {
                return null;
            }
        }; 
    }
}
