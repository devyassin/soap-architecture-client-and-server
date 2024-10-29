package org.yassine.graphqlws.exceptions;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CustomerExceptionResolver extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return new GraphQLError() {

            @Override
            public String getMessage() {
                return ex.getMessage();
            }

            @Override
            public List<SourceLocation> getLocations() {
                return env.getField().getSourceLocation() != null ?
                        List.of(env.getField().getSourceLocation()) : null;
            }

            @Override
            public ErrorClassification getErrorType() {
                return null;
            }

            @Override
            public List<Object> getPath() {
                return GraphQLError.super.getPath();
            }

            @Override
            public Map<String, Object> toSpecification() {
                return GraphQLError.super.toSpecification();
            }

            @Override
            public Map<String, Object> getExtensions() {
                return GraphQLError.super.getExtensions();
            }
        };
    }
}